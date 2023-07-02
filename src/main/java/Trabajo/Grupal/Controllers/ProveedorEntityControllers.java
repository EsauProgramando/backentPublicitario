package Trabajo.Grupal.Controllers;

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
import org.springframework.web.bind.annotation.RestController;

import Trabajo.Grupal.Entity.ProveedorEntity;

import Trabajo.Grupal.Service.IProveedorService;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost")
public class ProveedorEntityControllers {
    private final IProveedorService proveedorService;

    @Autowired
    public ProveedorEntityControllers(IProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping("/proveedor")
    public List<ProveedorEntity> buscarTodos() {
        return proveedorService.buscarTodos();
    }

    @PostMapping("/proveedor")
    public ProveedorEntity guardar(@RequestBody ProveedorEntity proveedor) {
        proveedorService.guardar(proveedor);
        return proveedor;
    }

    @PutMapping("/proveedor")
    public ProveedorEntity modificar(@RequestBody ProveedorEntity proveedor) {
        proveedorService.modificar(proveedor);
        return proveedor;
    }

    @GetMapping("/proveedor/{id}")
    public Optional<ProveedorEntity> buscarId(@PathVariable("id") Integer id) {
        return proveedorService.buscarId(id);
    }

    @DeleteMapping("/proveedor/{id}")
    public String eliminar(@PathVariable Integer id) {
        proveedorService.eliminar(id);
        return "Proveedor eliminado";
    }
}
