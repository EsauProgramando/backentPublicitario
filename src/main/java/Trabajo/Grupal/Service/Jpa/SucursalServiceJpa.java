package Trabajo.Grupal.Service.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Trabajo.Grupal.Entity.SucursalEntity;
import Trabajo.Grupal.Entity.Repository.SucursalRepository;
import Trabajo.Grupal.Service.ISucursalService;

@Service
public class SucursalServiceJpa implements ISucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<SucursalEntity> buscarTodos() {
        return sucursalRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(SucursalEntity sucursal) {
        sucursalRepository.save(sucursal);
    }

    @Override
    @Transactional
    public void modificar(SucursalEntity sucursal) {
        sucursalRepository.save(sucursal);
    }

    @Override
    public Optional<SucursalEntity> buscarId(Integer id) {
        return sucursalRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        sucursalRepository.deleteById(id);
    }
}
