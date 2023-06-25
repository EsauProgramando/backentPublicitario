package Trabajo.Grupal.Service.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Trabajo.Grupal.Entity.DetalleVentaEntity;
import Trabajo.Grupal.Entity.Repository.DetalleVentaRepository;
import Trabajo.Grupal.Service.IDetalleVentaService;

@Service
public class DetalleVentaEntityJpa implements IDetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Override
    public List<DetalleVentaEntity> buscarTodos() {
        return detalleVentaRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(DetalleVentaEntity detalleVenta) {
        detalleVentaRepository.save(detalleVenta);
    }

    @Override
    @Transactional
    public void modificar(DetalleVentaEntity detalleVenta) {
        detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public Optional<DetalleVentaEntity> buscarId(Integer id) {
        return detalleVentaRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        detalleVentaRepository.deleteById(id);
    }
}