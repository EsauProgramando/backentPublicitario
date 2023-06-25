package Trabajo.Grupal.Service;

import java.util.List;
import java.util.Optional;

import Trabajo.Grupal.Entity.MarcaEntity;

public interface IMarcaService {
    List<MarcaEntity> buscarTodos(); // READ

    void guardar(MarcaEntity marca); // CREATE

    void modificar(MarcaEntity marca); // UPDATE

    Optional<MarcaEntity> buscarId(Integer id); // READ

    void eliminar(Integer id); // DELETE
}