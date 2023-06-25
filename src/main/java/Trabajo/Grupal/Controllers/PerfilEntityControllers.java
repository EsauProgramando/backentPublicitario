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

import Trabajo.Grupal.Entity.PerfilEntity;
import Trabajo.Grupal.Service.IPerfilService;

@RestController
@RequestMapping("/admin")
public class PerfilEntityControllers {
    @Autowired
    private IPerfilService Perfilservice;

    @GetMapping("/perfil")
    public List<PerfilEntity> buscarTodos() {
        return Perfilservice.buscarTodos();
    }

    @PostMapping("/perfil")
    public PerfilEntity guardar(@RequestBody PerfilEntity perfil) {
    	Perfilservice.guardar(perfil);
        return perfil;
    }

    @PutMapping("/perfil")
    public PerfilEntity modificar(@RequestBody PerfilEntity perfil) {
    	Perfilservice.modificar(perfil);
        return perfil;
    }

    @GetMapping("/perfil/{id}")
    public Optional<PerfilEntity> buscarId(@PathVariable("id") Integer id) {
        return Perfilservice.buscarId(id);
    }

    @DeleteMapping("/perfil/{id}")
    public String eliminar(@PathVariable Integer id) {
    	Perfilservice.eliminar(id);
        return "Perfil eliminado";
    }
}
