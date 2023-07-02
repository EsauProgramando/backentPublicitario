package Trabajo.Grupal.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Trabajo.Grupal.Entity.ProvinciaEntity;
import Trabajo.Grupal.Service.IProvinciaService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost")
public class ProvinciaEntityControllers {

    private final IProvinciaService provinciaService;

    @Autowired
    public ProvinciaEntityControllers(IProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    @GetMapping("/provincia")
    public List<ProvinciaEntity> buscarTodos() {
        return provinciaService.buscarTodos();
    }

    @PostMapping("/provincia")
    public ProvinciaEntity guardar(@RequestBody ProvinciaEntity provincia) {
        provinciaService.guardar(provincia);
        return provincia;
    }

    @PutMapping("/provincia")
    public ProvinciaEntity modificar(@RequestBody ProvinciaEntity provincia) {
        provinciaService.modificar(provincia);
        return provincia;
    }

    @GetMapping("/provincia/{id}")
    public Optional<ProvinciaEntity> buscarId(@PathVariable("id") Integer id) {
        return provinciaService.buscarId(id);
    }

    @DeleteMapping("/provincia/{id}")
    public String eliminar(@PathVariable Integer id) {
        provinciaService.eliminar(id);
        return "Provincia eliminada";
    }
}
