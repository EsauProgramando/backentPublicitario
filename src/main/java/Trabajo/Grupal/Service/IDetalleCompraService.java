package Trabajo.Grupal.Service;

import java.util.List;
import java.util.Optional;

import Trabajo.Grupal.Entity.DetalleCompraEntity;

public interface IDetalleCompraService {
    List<DetalleCompraEntity> buscarTodos(); // READ

    void guardar(DetalleCompraEntity detalleCompra); // CREATE

    void modificar(DetalleCompraEntity detalleCompra); // UPDATE

    Optional<DetalleCompraEntity> buscarId(Integer id); // READ

    void eliminar(Integer id); // DELETE
}
