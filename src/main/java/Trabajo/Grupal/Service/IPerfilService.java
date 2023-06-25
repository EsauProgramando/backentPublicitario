package Trabajo.Grupal.Service;

import java.util.List;
import java.util.Optional;

import Trabajo.Grupal.Entity.PerfilEntity;

public interface IPerfilService {
    List<PerfilEntity> buscarTodos(); // READ

    void guardar(PerfilEntity perfil); // CREATE

    void modificar(PerfilEntity perfil); // UPDATE

    Optional<PerfilEntity> buscarId(Integer id); // READ

    void eliminar(Integer id); // DELETE
}
