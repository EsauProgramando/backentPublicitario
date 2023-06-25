package Trabajo.Grupal.Service.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Trabajo.Grupal.Entity.ProveedorEntity;
import Trabajo.Grupal.Entity.Repository.ProveedorRepository;
import Trabajo.Grupal.Service.IProveedorService;

@Service
public class ProveedorEntityJpa implements IProveedorService {

    private final ProveedorRepository proveedorRepository;

    @Autowired
    public ProveedorEntityJpa(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public List<ProveedorEntity> buscarTodos() {
        return proveedorRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(ProveedorEntity proveedor) {
        proveedorRepository.save(proveedor);
    }

    @Override
    @Transactional
    public void modificar(ProveedorEntity proveedor) {
        proveedorRepository.save(proveedor);
    }

    @Override
    public Optional<ProveedorEntity> buscarId(Integer id) {
        return proveedorRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        proveedorRepository.deleteById(id);
    }
}
