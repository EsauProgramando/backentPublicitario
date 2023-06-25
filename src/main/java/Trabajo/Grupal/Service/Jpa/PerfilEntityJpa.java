package Trabajo.Grupal.Service.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Trabajo.Grupal.Entity.PerfilEntity;
import Trabajo.Grupal.Entity.Repository.PerfilRepository;
import Trabajo.Grupal.Service.IPerfilService;

@Service
public class PerfilEntityJpa implements IPerfilService {

    @Autowired
    private PerfilRepository Perfilservice;

    @Override
    public List<PerfilEntity> buscarTodos() {
        return Perfilservice.findAll();
    }

    @Override
    @Transactional
    public void guardar(PerfilEntity perfil) {
    	Perfilservice.save(perfil);
    }

    @Override
    @Transactional
    public void modificar(PerfilEntity perfil) {
    	Perfilservice.save(perfil);
    }

    @Override
    public Optional<PerfilEntity> buscarId(Integer id) {
        return Perfilservice.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
    	Perfilservice.deleteById(id);
    }
}
