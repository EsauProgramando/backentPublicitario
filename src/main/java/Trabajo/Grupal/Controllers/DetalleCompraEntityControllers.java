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

import Trabajo.Grupal.Entity.DetalleCompraEntity;
import Trabajo.Grupal.Service.IDetalleCompraService;

@RestController
@RequestMapping("/admin")
public class DetalleCompraEntityControllers {

    @Autowired
    private IDetalleCompraService detalleCompraService;

    @GetMapping("/detallecompra")
    public List<DetalleCompraEntity> buscarTodos() {
        return detalleCompraService.buscarTodos();
    }

    @PostMapping("/detallecompra")
    public DetalleCompraEntity guardar(@RequestBody DetalleCompraEntity detalleCompra) {
        detalleCompraService.guardar(detalleCompra);
        return detalleCompra;
    }

    @PutMapping("/detallecompra")
    public DetalleCompraEntity modificar(@RequestBody DetalleCompraEntity detalleCompra) {
        detalleCompraService.modificar(detalleCompra);
        return detalleCompra;
    }

    @GetMapping("/detallecompra/{id}")
    public Optional<DetalleCompraEntity> buscarId(@PathVariable("id") Integer id) {
        return detalleCompraService.buscarId(id);
    }

    @DeleteMapping("/detallecompra/{id}")
    public String eliminar(@PathVariable Integer id) {
        detalleCompraService.eliminar(id);
        return "Detalle de compra eliminado";
    }
}