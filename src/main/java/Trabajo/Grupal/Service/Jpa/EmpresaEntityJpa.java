package Trabajo.Grupal.Service.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Trabajo.Grupal.Entity.EmpresaEntity;
import Trabajo.Grupal.Entity.Repository.EmpresaRepository;
import Trabajo.Grupal.Service.IEmpresaService;

@Service
public class EmpresaEntityJpa implements IEmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<EmpresaEntity> buscarTodos() {
        return empresaRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(EmpresaEntity empresa) {
        empresaRepository.save(empresa);
    }

    @Override
    @Transactional
    public void modificar(EmpresaEntity empresa) {
        empresaRepository.save(empresa);
    }

    @Override
    public Optional<EmpresaEntity> buscarId(Integer id) {
        return empresaRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        empresaRepository.deleteById(id);
    }

	@Override
	@Transactional(readOnly = true)
	public EmpresaEntity findById(Integer id) {
		return empresaRepository.findById(id).orElse(null);
	}
}
