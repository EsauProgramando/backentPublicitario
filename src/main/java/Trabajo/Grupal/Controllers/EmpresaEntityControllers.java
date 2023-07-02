package Trabajo.Grupal.Controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Trabajo.Grupal.Entity.EmpresaEntity;
import Trabajo.Grupal.Service.IEmpresaService;
import Trabajo.Grupal.Service.IUploadFileService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class EmpresaEntityControllers {
    @Autowired
    private IEmpresaService empresaService;
	@Autowired
	private IUploadFileService uploadService;

    @GetMapping("/empresa")
    public List<EmpresaEntity> buscarTodos() {
        return empresaService.buscarTodos();
    }

    @PostMapping("/empresa")
    public EmpresaEntity guardar(@RequestBody EmpresaEntity empresa) {
        empresaService.guardar(empresa);
        return empresa;
    }

    @PutMapping("/empresa")
    public EmpresaEntity modificar(@RequestBody EmpresaEntity empresa) {
        empresaService.modificar(empresa);
        return empresa;
    }

    @GetMapping("/empresa/{id}")
    public Optional<EmpresaEntity> buscarId(@PathVariable("id") Integer id) {
        return empresaService.buscarId(id);
    }

    @DeleteMapping("/empresa/{id}")
    public String eliminar(@PathVariable Integer id) {
    	EmpresaEntity empresa = empresaService.findById(id);
    	String nombreLogoAnterior = empresa.getLogo();
    	uploadService.eliminar(nombreLogoAnterior);
        empresaService.eliminar(id);
        return "Empresa eliminada";
    }
	@GetMapping("/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto) {

		Resource recurso = null;

		try {
			recurso = uploadService.cargar(nombreFoto);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

		HttpHeaders cabecera = new HttpHeaders();

		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");

		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}
	@PostMapping("/empresa/upload")
	public ResponseEntity<?> uploadLogo(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Integer id) {
		Map<String, Object> response = new HashMap<>();
		EmpresaEntity empresa = empresaService.findById(id);

		if (!archivo.isEmpty()) {
			String nombreArchivo = null;
			try {
				nombreArchivo = uploadService.copiar(archivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen del logo");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String nombreLogoAnterior = empresa.getLogo();

			uploadService.eliminar(nombreLogoAnterior);
			empresa.setLogo(nombreArchivo);
			empresaService.guardar(empresa);
			response.put("empresa", empresa);
			response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);// 201
	}
}
