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

import Trabajo.Grupal.Entity.VentaEntity;
import Trabajo.Grupal.Service.IVentaService;

@RestController
@RequestMapping("/admin")
public class VentaEntityControllers {

    @Autowired
    private IVentaService ventaService;

    @GetMapping("/venta")
    public List<VentaEntity> buscarTodos() {
        return ventaService.buscarTodos();
    }

    @PostMapping("/venta")
    public VentaEntity guardar(@RequestBody VentaEntity venta) {
        ventaService.guardar(venta);
        return venta;
    }

    @PutMapping("/venta")
    public VentaEntity modificar(@RequestBody VentaEntity venta) {
        ventaService.modificar(venta);
        return venta;
    }

    @GetMapping("/venta/{id}")
    public Optional<VentaEntity> buscarId(@PathVariable("id") Integer id) {
        return ventaService.buscarId(id);
    }

    @DeleteMapping("/venta/{id}")
    public String eliminar(@PathVariable Integer id) {
        ventaService.eliminar(id);
        return "Venta eliminada";
    }
}