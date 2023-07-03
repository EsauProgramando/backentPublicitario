package Trabajo.Grupal.Controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import Trabajo.Grupal.Entity.ProductoEntity;
import Trabajo.Grupal.Service.IProductoService;
import Trabajo.Grupal.Service.IUploadFileService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class ProductoEntityControllers {

    @Autowired
    private IProductoService productoService;
	@Autowired
	private IUploadFileService uploadService;

    @GetMapping("/producto")
    public List<ProductoEntity> buscarTodos() {
        return productoService.buscarTodos();
    }

    @PostMapping("/producto")
    public ProductoEntity guardar(@RequestBody ProductoEntity producto) {
    	
  
        productoService.guardar(producto);
        return producto;
    }

    @PutMapping("/producto")
    public ProductoEntity modificar(@RequestBody ProductoEntity producto) {  	
        productoService.modificar(producto);
        return producto;
    }

    @GetMapping("/producto/{id}")
    public Optional<ProductoEntity> buscarId(@PathVariable("id") Integer id) {
        return productoService.buscarId(id);
    }

    @DeleteMapping("/producto/{id}")
    public String eliminar(@PathVariable Integer id) {
    	ProductoEntity producto = productoService.findById(id);
    	String nombreLogoAnterior = producto.getProductoImg();
    	uploadService.eliminar(nombreLogoAnterior);
        productoService.eliminar(id);
        return "Producto eliminado";
    }
	@PostMapping("/producto/upload")
	public ResponseEntity<?> uploadProducto(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Integer id) {
		Map<String, Object> response = new HashMap<>();
		ProductoEntity producto = productoService.findById(id);
		
		if (!archivo.isEmpty()) {
			String nombreArchivo = null;
			try {
				nombreArchivo = uploadService.copiar(archivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen del producto");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String nombreLogoAnterior = producto.getProductoImg();

			uploadService.eliminar(nombreLogoAnterior);
			producto.setProductoImg(nombreArchivo);
			productoService.guardar(producto);
			response.put("producto", producto);
			response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);// 201
	
	}
}