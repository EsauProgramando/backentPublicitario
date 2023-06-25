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

import Trabajo.Grupal.Entity.CategoriaEntity;
import Trabajo.Grupal.Service.ICategoriaService;

@RestController
@RequestMapping("/admin")
public class CategoriaEntityControllers {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/categoria")
    public List<CategoriaEntity> buscarTodos() {
        return categoriaService.buscarTodos();
    }

    @PostMapping("/categoria")
    public CategoriaEntity guardar(@RequestBody CategoriaEntity categoria) {
        categoriaService.guardar(categoria);
        return categoria;
    }

    @PutMapping("/categoria")
    public CategoriaEntity modificar(@RequestBody CategoriaEntity categoria) {
        categoriaService.modificar(categoria);
        return categoria;
    }

    @GetMapping("/categoria/{id}")
    public Optional<CategoriaEntity> buscarId(@PathVariable("id") Integer id) {
        return categoriaService.buscarId(id);
    }

    @DeleteMapping("/categoria/{id}")
    public String eliminar(@PathVariable Integer id) {
        categoriaService.eliminar(id);
        return "Categoría eliminada";
    }
}