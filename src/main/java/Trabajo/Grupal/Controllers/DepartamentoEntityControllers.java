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

import Trabajo.Grupal.Entity.DepartamentoEntity;
import Trabajo.Grupal.Service.IDepartamentoService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class DepartamentoEntityControllers {

    @Autowired
    private IDepartamentoService departamentoService;

    @GetMapping("/departamento")
    public List<DepartamentoEntity> buscarTodos() {
        return departamentoService.buscarTodos();
    }

    @PostMapping("/departamento")
    public DepartamentoEntity guardar(@RequestBody DepartamentoEntity departamento) {
        departamentoService.guardar(departamento);
        return departamento;
    }

    @PutMapping("/departamento")
    public DepartamentoEntity modificar(@RequestBody DepartamentoEntity departamento) {
        departamentoService.modificar(departamento);
        return departamento;
    }

    @GetMapping("/departamento/{id}")
    public Optional<DepartamentoEntity> buscarId(@PathVariable("id") Integer id) {
        return departamentoService.buscarId(id);
    }

    @DeleteMapping("/departamento/{id}")
    public String eliminar(@PathVariable Integer id) {
        departamentoService.eliminar(id);
        return "Departamento eliminado";
    }
}
