package Trabajo.Grupal.Service;

import java.util.List;
import java.util.Optional;

import Trabajo.Grupal.Entity.SucursalEntity;

public interface ISucursalService {
    List<SucursalEntity> buscarTodos(); // READ

    void guardar(SucursalEntity sucursal); // CREATE

    void modificar(SucursalEntity sucursal); // UPDATE

    Optional<SucursalEntity> buscarId(Integer id); // READ

    void eliminar(Integer id); // DELETE
}
