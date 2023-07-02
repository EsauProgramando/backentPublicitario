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

import Trabajo.Grupal.Entity.DetalleVentaEntity;
import Trabajo.Grupal.Service.IDetalleVentaService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost")
public class DetalleVentaEntityControllers {

    @Autowired
    private IDetalleVentaService detalleVentaService;

    @GetMapping("/detalleventa")
    public List<DetalleVentaEntity> buscarTodos() {
        return detalleVentaService.buscarTodos();
    }

    @PostMapping("/detalleventa")
    public DetalleVentaEntity guardar(@RequestBody DetalleVentaEntity detalleVenta) {
        detalleVentaService.guardar(detalleVenta);
        return detalleVenta;
    }

    @PutMapping("/detalleventa")
    public DetalleVentaEntity modificar(@RequestBody DetalleVentaEntity detalleVenta) {
        detalleVentaService.modificar(detalleVenta);
        return detalleVenta;
    }

    @GetMapping("/detalleventa/{id}")
    public Optional<DetalleVentaEntity> buscarId(@PathVariable("id") Integer id) {
        return detalleVentaService.buscarId(id);
    }

    @DeleteMapping("/detalleventa/{id}")
    public String eliminar(@PathVariable Integer id) {
        detalleVentaService.eliminar(id);
        return "DetalleVenta eliminado";
    }
}
