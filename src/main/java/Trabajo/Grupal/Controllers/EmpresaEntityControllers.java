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

import Trabajo.Grupal.Entity.EmpresaEntity;
import Trabajo.Grupal.Service.IEmpresaService;

@RestController
@RequestMapping("/admin")
public class EmpresaEntityControllers {
    @Autowired
    private IEmpresaService empresaService;

    @GetMapping("/empresa")
    public List<EmpresaEntity> buscarTodos() {
        return empresaService.buscarTodos();
    }

    @PostMapping("/empresa")
    public EmpresaEntity guardar(@RequestBody EmpresaEntity empresa) {
        empresaService.guardar(empresa);
        return empresa;
    }

    @PutMapping("/empresa")
    public EmpresaEntity modificar(@RequestBody EmpresaEntity empresa) {
        empresaService.modificar(empresa);
        return empresa;
    }

    @GetMapping("/empresa/{id}")
    public Optional<EmpresaEntity> buscarId(@PathVariable("id") Integer id) {
        return empresaService.buscarId(id);
    }

    @DeleteMapping("/empresa/{id}")
    public String eliminar(@PathVariable Integer id) {
        empresaService.eliminar(id);
        return "Empresa eliminada";
    }
}
