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

import Trabajo.Grupal.Entity.SucursalEntity;
import Trabajo.Grupal.Service.ISucursalService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost")
public class SucursalEntityControllers {

    @Autowired
    private ISucursalService sucursalService;

    @GetMapping("/sucursal")
    public List<SucursalEntity> buscarTodos() {
        return sucursalService.buscarTodos();
    }

    @PostMapping("/sucursal")
    public SucursalEntity guardar(@RequestBody SucursalEntity sucursal) {
        sucursalService.guardar(sucursal);
        return sucursal;
    }

    @PutMapping("/sucursal")
    public SucursalEntity modificar(@RequestBody SucursalEntity sucursal) {
        sucursalService.modificar(sucursal);
        return sucursal;
    }

    @GetMapping("/sucursal/{id}")
    public Optional<SucursalEntity> buscarId(@PathVariable("id") Integer id) {
        return sucursalService.buscarId(id);
    }

    @DeleteMapping("/sucursal/{id}")
    public String eliminar(@PathVariable Integer id) {
        sucursalService.eliminar(id);
        return "Sucursal eliminada";
    }
}
