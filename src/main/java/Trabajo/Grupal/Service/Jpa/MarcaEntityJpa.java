package Trabajo.Grupal.Service.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Trabajo.Grupal.Entity.MarcaEntity;
import Trabajo.Grupal.Entity.Repository.MarcaRepository;
import Trabajo.Grupal.Service.IMarcaService;

@Service
public class MarcaEntityJpa implements IMarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<MarcaEntity> buscarTodos() {
        return marcaRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(MarcaEntity marca) {
        marcaRepository.save(marca);
    }

    @Override
    @Transactional
    public void modificar(MarcaEntity marca) {
        marcaRepository.save(marca);
    }

    @Override
    public Optional<MarcaEntity> buscarId(Integer id) {
        return marcaRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        marcaRepository.deleteById(id);
    }
}