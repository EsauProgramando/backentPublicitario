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

import Trabajo.Grupal.Entity.CompraEntity;
import Trabajo.Grupal.Service.ICompraService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class CompraEntityControllers {

    @Autowired
    private ICompraService compraService;

    @GetMapping("/compra")
    public List<CompraEntity> buscarTodos() {
        return compraService.buscarTodos();
    }

    @PostMapping("/compra")
    public CompraEntity guardar(@RequestBody CompraEntity compra) {
        compraService.guardar(compra);
        return compra;
    }

    @PutMapping("/compra")
    public CompraEntity modificar(@RequestBody CompraEntity compra) {
        compraService.modificar(compra);
        return compra;
    }

    @GetMapping("/compra/{id}")
    public Optional<CompraEntity> buscarId(@PathVariable("id") Integer id) {
        return compraService.buscarId(id);
    }

    @DeleteMapping("/compra/{id}")
    public String eliminar(@PathVariable Integer id) {
        compraService.eliminar(id);
        return "Compra eliminada";
    }
}