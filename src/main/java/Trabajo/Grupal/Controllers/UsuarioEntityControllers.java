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

import Trabajo.Grupal.Entity.UsuarioEntity;
import Trabajo.Grupal.Service.IUsuarioService;

@RestController
@RequestMapping("/admin")
public class UsuarioEntityControllers {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/usuario")
    public List<UsuarioEntity> buscarTodos() {
        return usuarioService.buscarTodos();
    }

    @PostMapping("/usuario")
    public UsuarioEntity guardar(@RequestBody UsuarioEntity usuario) {
        usuarioService.guardar(usuario);
        return usuario;
    }

    @PutMapping("/usuario")
    public UsuarioEntity modificar(@RequestBody UsuarioEntity usuario) {
        usuarioService.modificar(usuario);
        return usuario;
    }

    @GetMapping("/usuario/{id}")
    public Optional<UsuarioEntity> buscarId(@PathVariable("id") Integer id) {
        return usuarioService.buscarId(id);
    }

    @DeleteMapping("/usuario/{id}")
    public String eliminar(@PathVariable Integer id) {
        usuarioService.eliminar(id);
        return "Usuario eliminado";
    }
}