package Trabajo.Grupal.Service;

import java.util.List;
import java.util.Optional;

import Trabajo.Grupal.Entity.CompraEntity;

public interface ICompraService {
    List<CompraEntity> buscarTodos(); // READ

    void guardar(CompraEntity compra); // CREATE

    void modificar(CompraEntity compra); // UPDATE

    Optional<CompraEntity> buscarId(Integer id); // READ

    void eliminar(Integer id); // DELETE
}

