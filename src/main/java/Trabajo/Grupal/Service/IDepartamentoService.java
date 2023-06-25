package Trabajo.Grupal.Service;

import java.util.List;
import java.util.Optional;

import Trabajo.Grupal.Entity.DepartamentoEntity;

public interface IDepartamentoService {
    List<DepartamentoEntity> buscarTodos(); // READ

    void guardar(DepartamentoEntity deparatamento); // CREATE

    void modificar(DepartamentoEntity departamento); // UPDATE

    Optional<DepartamentoEntity> buscarId(Integer id); // READ

    void eliminar(Integer id); // DELETE
}
