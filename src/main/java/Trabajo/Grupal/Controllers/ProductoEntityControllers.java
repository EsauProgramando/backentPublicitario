package Trabajo.Grupal.Controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Trabajo.Grupal.Entity.ProductoEntity;
import Trabajo.Grupal.Service.IProductoService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:8012")
public class ProductoEntityControllers {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/producto")
    public List<ProductoEntity> buscarTodos() {
        return productoService.buscarTodos();
    }

    @PostMapping("/producto")
    public ProductoEntity guardar(@RequestBody ProductoEntity producto,@RequestParam("imageFile") MultipartFile file) throws IOException {
    	 // Verificar si se seleccionó un archivo
        if (file.isEmpty()) {
            // Manejar el caso de archivo no seleccionado
           Path directorioImg = Paths.get("img");
           String rutaAbsoluta = directorioImg.toFile().getAbsolutePath();
           
           byte[] bytesImg = file.getBytes();
           Path rutaCompleta = Paths.get(rutaAbsoluta+"//"+file.getOriginalFilename());
           Files.write(rutaCompleta,bytesImg);
        }

        producto.setFilePath(file.getOriginalFilename());
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
        productoService.eliminar(id);
        return "Producto eliminado";
    }
    
    
}