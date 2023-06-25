package Trabajo.Grupal.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Trabajo.Grupal.Entity.DistritoEntity;
import Trabajo.Grupal.Service.IDistritoService;

@RestController
@RequestMapping("/admin")
public class DistritoEntityControllers {

    private final IDistritoService distritoService;

    @Autowired
    public DistritoEntityControllers(IDistritoService distritoService) {
        this.distritoService = distritoService;
    }

    @GetMapping("/distrito")
    public List<DistritoEntity> buscarTodos() {
        return distritoService.buscarTodos();
    }

    @PostMapping("/distrito")
    public DistritoEntity guardar(@RequestBody DistritoEntity distrito) {
        distritoService.guardar(distrito);
        return distrito;
    }

    @PutMapping("/distrito")
    public DistritoEntity modificar(@RequestBody DistritoEntity distrito) {
        distritoService.modificar(distrito);
        return distrito;
    }

    @GetMapping("/distrito/{id}")
    public Optional<DistritoEntity> buscarId(@PathVariable("id") Integer id) {
        return distritoService.buscarId(id);
    }

    @DeleteMapping("/distrito/{id}")
    public String eliminar(@PathVariable Integer id) {
        distritoService.eliminar(id);
        return "Distrito eliminado";
    }
}
