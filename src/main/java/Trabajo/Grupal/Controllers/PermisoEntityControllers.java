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

import Trabajo.Grupal.Entity.PermisoEntity;
import Trabajo.Grupal.Service.IPermisoService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class PermisoEntityControllers {

    @Autowired
    private IPermisoService permisoService;

    @GetMapping("/permisos")
    public List<PermisoEntity> buscarTodos() {
        return permisoService.buscarTodos();
    }

    @PostMapping("/permisos")
    public PermisoEntity guardar(@RequestBody PermisoEntity permiso) {
        permisoService.guardar(permiso);
        return permiso;
    }

    @PutMapping("/permisos")
    public PermisoEntity modificar(@RequestBody PermisoEntity permiso) {
        permisoService.modificar(permiso);
        return permiso;
    }

    @GetMapping("/permisos/{id}")
    public Optional<PermisoEntity> buscarId(@PathVariable("id") Integer id) {
        return permisoService.buscarId(id);
    }

    @DeleteMapping("/permisos/{id}")
    public String eliminar(@PathVariable Integer id) {
        permisoService.eliminar(id);
        return "Permiso eliminado";
    }
}