package Trabajo.Grupal.Service.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Trabajo.Grupal.Entity.ProductoEntity;
import Trabajo.Grupal.Entity.Repository.ProductoRepository;
import Trabajo.Grupal.Service.IProductoService;

@Service
public class ProductoEntityJpa implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoEntity> buscarTodos() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(ProductoEntity producto) {
        productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void modificar(ProductoEntity producto) {
        productoRepository.save(producto);
    }

    @Override
    public Optional<ProductoEntity> buscarId(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }
}