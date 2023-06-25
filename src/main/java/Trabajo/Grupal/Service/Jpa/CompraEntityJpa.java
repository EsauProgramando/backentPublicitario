package Trabajo.Grupal.Service.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Trabajo.Grupal.Entity.CompraEntity;
import Trabajo.Grupal.Entity.Repository.CompraRepository;
import Trabajo.Grupal.Service.ICompraService;

@Service
public class CompraEntityJpa implements ICompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public List<CompraEntity> buscarTodos() {
        return compraRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(CompraEntity compra) {
        compraRepository.save(compra);
    }

    @Override
    @Transactional
    public void modificar(CompraEntity compra) {
        compraRepository.save(compra);
    }

    @Override
    public Optional<CompraEntity> buscarId(Integer id) {
        return compraRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        compraRepository.deleteById(id);
    }
}