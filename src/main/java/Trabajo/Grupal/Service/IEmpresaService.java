package Trabajo.Grupal.Service;

import java.util.List;
import java.util.Optional;

import Trabajo.Grupal.Entity.EmpresaEntity;

public interface IEmpresaService {
	List<EmpresaEntity> buscarTodos(); // READ

    void guardar(EmpresaEntity Empresa); // CREATE

    void modificar(EmpresaEntity Empresa); // UPDATE

    Optional<EmpresaEntity> buscarId(Integer id); // READ

    void eliminar(Integer id); // DELETE
}

