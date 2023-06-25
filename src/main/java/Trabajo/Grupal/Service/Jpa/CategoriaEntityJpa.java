package Trabajo.Grupal.Service.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Trabajo.Grupal.Entity.CategoriaEntity;
import Trabajo.Grupal.Entity.Repository.CategoriaRepository;
import Trabajo.Grupal.Service.ICategoriaService;

@Service
public class CategoriaEntityJpa implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaEntity> buscarTodos() {
        return categoriaRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(CategoriaEntity categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public void modificar(CategoriaEntity categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public Optional<CategoriaEntity> buscarId(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        categoriaRepository.deleteById(id);
    }
}