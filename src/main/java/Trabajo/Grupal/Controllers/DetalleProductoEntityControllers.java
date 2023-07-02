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

import Trabajo.Grupal.Entity.DetalleProductoEntity;
import Trabajo.Grupal.Service.IDetalleProductoService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class DetalleProductoEntityControllers {

    @Autowired
    private IDetalleProductoService detalleProductoService;

    @GetMapping("/detalleproducto")
    public List<DetalleProductoEntity> buscarTodos() {
        return detalleProductoService.buscarTodos();
    }

    @PostMapping("/detalleproducto")
    public DetalleProductoEntity guardar(@RequestBody DetalleProductoEntity detalleProducto) {
        detalleProductoService.guardar(detalleProducto);
        return detalleProducto;
    }

    @PutMapping("/detalleproducto")
    public DetalleProductoEntity modificar(@RequestBody DetalleProductoEntity detalleProducto) {
        detalleProductoService.modificar(detalleProducto);
        return detalleProducto;
    }

    @GetMapping("/detalleproducto/{id}")
    public Optional<DetalleProductoEntity> buscarId(@PathVariable("id") Integer id) {
        return detalleProductoService.buscarId(id);
    }

    @DeleteMapping("/detalleproducto/{id}")
    public String eliminar(@PathVariable Integer id) {
        detalleProductoService.eliminar(id);
        return "Detalle de producto eliminado";
    }
}
