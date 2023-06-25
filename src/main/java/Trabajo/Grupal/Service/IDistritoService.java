package Trabajo.Grupal.Service;

import java.util.List;
import java.util.Optional;

import Trabajo.Grupal.Entity.DistritoEntity;

public interface IDistritoService {
    List<DistritoEntity> buscarTodos(); // READ

    void guardar(DistritoEntity distrito); // CREATE

    void modificar(DistritoEntity distrito); // UPDATE

    Optional<DistritoEntity> buscarId(Integer id); // READ

    void eliminar(Integer id); // DELETE
}
