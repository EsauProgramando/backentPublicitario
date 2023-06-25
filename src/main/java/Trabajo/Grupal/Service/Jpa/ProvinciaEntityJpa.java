package Trabajo.Grupal.Service.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Trabajo.Grupal.Entity.ProvinciaEntity;
import Trabajo.Grupal.Entity.Repository.ProvinciaRepository;
import Trabajo.Grupal.Service.IProvinciaService;

@Service
public class ProvinciaEntityJpa implements IProvinciaService {

    private final ProvinciaRepository provinciaRepository;

    @Autowired
    public ProvinciaEntityJpa(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }

    @Override
    public List<ProvinciaEntity> buscarTodos() {
        return provinciaRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(ProvinciaEntity provincia) {
        provinciaRepository.save(provincia);
    }

    @Override
    @Transactional
    public void modificar(ProvinciaEntity provincia) {
        provinciaRepository.save(provincia);
    }

    @Override
    public Optional<ProvinciaEntity> buscarId(Integer id) {
        return provinciaRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        provinciaRepository.deleteById(id);
    }
}
