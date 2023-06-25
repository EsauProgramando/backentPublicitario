package Trabajo.Grupal.Service.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Trabajo.Grupal.Entity.DistritoEntity;
import Trabajo.Grupal.Entity.Repository.DistritoRepository;
import Trabajo.Grupal.Service.IDistritoService;

@Service
public class DistritoServiceJpa implements IDistritoService {

    private final DistritoRepository distritoRepository;

    @Autowired
    public DistritoServiceJpa(DistritoRepository distritoRepository) {
        this.distritoRepository = distritoRepository;
    }

    @Override
    public List<DistritoEntity> buscarTodos() {
        return distritoRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(DistritoEntity distrito) {
        distritoRepository.save(distrito);
    }

    @Override
    @Transactional
    public void modificar(DistritoEntity distrito) {
        distritoRepository.save(distrito);
    }

    @Override
    public Optional<DistritoEntity> buscarId(Integer id) {
        return distritoRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        distritoRepository.deleteById(id);
    }
}
