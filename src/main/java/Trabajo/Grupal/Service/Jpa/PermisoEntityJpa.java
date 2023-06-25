package Trabajo.Grupal.Service.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Trabajo.Grupal.Entity.PermisoEntity;
import Trabajo.Grupal.Entity.Repository.PermisoRepository;
import Trabajo.Grupal.Service.IPermisoService;

@Service
public class PermisoEntityJpa implements IPermisoService {

    @Autowired
    private PermisoRepository permisoRepository;

    @Override
    public List<PermisoEntity> buscarTodos() {
        return permisoRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(PermisoEntity permiso) {
        permisoRepository.save(permiso);
    }

    @Override
    @Transactional
    public void modificar(PermisoEntity permiso) {
        permisoRepository.save(permiso);
    }

    @Override
    public Optional<PermisoEntity> buscarId(Integer id) {
        return permisoRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        permisoRepository.deleteById(id);
    }
}