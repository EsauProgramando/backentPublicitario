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

import Trabajo.Grupal.Entity.MarcaEntity;
import Trabajo.Grupal.Service.IMarcaService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:8012")
public class MarcaEntityControllers {

    @Autowired
    private IMarcaService marcaService;

    @GetMapping("/marca")
    public List<MarcaEntity> buscarTodos() {
        return marcaService.buscarTodos();
    }

    @PostMapping("/marca")
    public MarcaEntity guardar(@RequestBody MarcaEntity marca) {
        marcaService.guardar(marca);
        return marca;
    }

    @PutMapping("/marca")
    public MarcaEntity modificar(@RequestBody MarcaEntity marca) {
        marcaService.modificar(marca);
        return marca;
    }

    @GetMapping("/marca/{id}")
    public Optional<MarcaEntity> buscarId(@PathVariable("id") Integer id) {
        return marcaService.buscarId(id);
    }

    @DeleteMapping("/marca/{id}")
    public String eliminar(@PathVariable Integer id) {
        marcaService.eliminar(id);
        return "Marca eliminada";
    }
}