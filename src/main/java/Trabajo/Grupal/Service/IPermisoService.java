package Trabajo.Grupal.Service;

import java.util.List;
import java.util.Optional;

import Trabajo.Grupal.Entity.PermisoEntity;

public interface IPermisoService {
    List<PermisoEntity> buscarTodos(); // READ

    void guardar(PermisoEntity permiso); // CREATE

    void modificar(PermisoEntity permiso); // UPDATE

    Optional<PermisoEntity> buscarId(Integer id); // READ

    void eliminar(Integer id); // DELETE
}