package Trabajo.Grupal.Service.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Trabajo.Grupal.Entity.DetalleProductoEntity;
import Trabajo.Grupal.Entity.Repository.DetalleProductoRepository;
import Trabajo.Grupal.Service.IDetalleProductoService;

@Service
public class DetalleProductoEntityJpa implements IDetalleProductoService {

    @Autowired
    private DetalleProductoRepository detalleProductoRepository;

    @Override
    public List<DetalleProductoEntity> buscarTodos() {
        return detalleProductoRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(DetalleProductoEntity detalleProducto) {
        detalleProductoRepository.save(detalleProducto);
    }

    @Override
    @Transactional
    public void modificar(DetalleProductoEntity detalleProducto) {
        detalleProductoRepository.save(detalleProducto);
    }

    @Override
    public Optional<DetalleProductoEntity> buscarId(Integer id) {
        return detalleProductoRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        detalleProductoRepository.deleteById(id);
    }
}