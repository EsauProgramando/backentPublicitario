package Trabajo.Grupal.Service;

import java.util.List;
import java.util.Optional;
import Trabajo.Grupal.Entity.ProveedorEntity;

public interface IProveedorService {
	List<ProveedorEntity> buscarTodos(); // READ

    void guardar(ProveedorEntity proveedor); // CREATE

    void modificar(ProveedorEntity proveedor); // UPDATE

    Optional<ProveedorEntity> buscarId(Integer id); // READ

    void eliminar(Integer id); // DELETE
}
