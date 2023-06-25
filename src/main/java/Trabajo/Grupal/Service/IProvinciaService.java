package Trabajo.Grupal.Service;

import java.util.List;
import java.util.Optional;
import Trabajo.Grupal.Entity.ProvinciaEntity;

public interface IProvinciaService {
    List<ProvinciaEntity> buscarTodos(); // READ

    void guardar(ProvinciaEntity provincia); // CREATE

    void modificar(ProvinciaEntity provincia); // UPDATE

    Optional<ProvinciaEntity> buscarId(Integer id); // READ

    void eliminar(Integer id); // DELETE
}
