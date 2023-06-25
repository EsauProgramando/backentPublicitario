package Trabajo.Grupal.Service.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Trabajo.Grupal.Entity.VentaEntity;
import Trabajo.Grupal.Entity.Repository.VentaRepository;
import Trabajo.Grupal.Service.IVentaService;

@Service
public class VentaEntityJpa implements IVentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<VentaEntity> buscarTodos() {
        return ventaRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(VentaEntity venta) {
        ventaRepository.save(venta);
    }

    @Override
    @Transactional
    public void modificar(VentaEntity venta) {
        ventaRepository.save(venta);
    }

    @Override
    public Optional<VentaEntity> buscarId(Integer id) {
        return ventaRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        ventaRepository.deleteById(id);
    }
}