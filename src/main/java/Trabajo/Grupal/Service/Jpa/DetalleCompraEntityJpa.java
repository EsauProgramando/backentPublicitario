package Trabajo.Grupal.Service.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Trabajo.Grupal.Entity.DetalleCompraEntity;
import Trabajo.Grupal.Entity.Repository.DetalleCompraRepository;
import Trabajo.Grupal.Service.IDetalleCompraService;

@Service
public class DetalleCompraEntityJpa implements IDetalleCompraService {

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Override
    public List<DetalleCompraEntity> buscarTodos() {
        return detalleCompraRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(DetalleCompraEntity detalleCompra) {
        detalleCompraRepository.save(detalleCompra);
    }

    @Override
    @Transactional
    public void modificar(DetalleCompraEntity detalleCompra) {
        detalleCompraRepository.save(detalleCompra);
    }

    @Override
    public Optional<DetalleCompraEntity> buscarId(Integer id) {
        return detalleCompraRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        detalleCompraRepository.deleteById(id);
    }
}