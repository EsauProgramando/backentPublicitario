package Trabajo.Grupal.Service.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Trabajo.Grupal.Entity.DepartamentoEntity;
import Trabajo.Grupal.Entity.Repository.DepartamentoRepository;
import Trabajo.Grupal.Service.IDepartamentoService;

@Service
public class DepartamentoEntityJpa implements IDepartamentoService {

    @Autowired
    private DepartamentoRepository reportedepartamento;

    @Override
    public List<DepartamentoEntity> buscarTodos() {
        return reportedepartamento.findAll();
    }

    @Override
    @Transactional
    public void guardar(DepartamentoEntity departamento) {
    	reportedepartamento.save(departamento);
    }

    @Override
    @Transactional
    public void modificar(DepartamentoEntity departamento) {
    	reportedepartamento.save(departamento);
    }

    @Override
    public Optional<DepartamentoEntity> buscarId(Integer id) {
        return reportedepartamento.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
    	reportedepartamento.deleteById(id);
    }
}
