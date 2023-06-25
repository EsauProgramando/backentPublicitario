package Trabajo.Grupal.Service;

import java.util.List;
import java.util.Optional;

import Trabajo.Grupal.Entity.CategoriaEntity;

public interface ICategoriaService {
    List<CategoriaEntity> buscarTodos(); // READ

    void guardar(CategoriaEntity categoria); // CREATE

    void modificar(CategoriaEntity categoria); // UPDATE

    Optional<CategoriaEntity> buscarId(Integer id); // READ

    void eliminar(Integer id); // DELETE
}