package Trabajo.Grupal.Service;

import java.util.List;
import java.util.Optional;

import Trabajo.Grupal.Entity.DetalleProductoEntity;

public interface IDetalleProductoService {
    List<DetalleProductoEntity> buscarTodos(); // READ

    void guardar(DetalleProductoEntity detalleProducto); // CREATE

    void modificar(DetalleProductoEntity detalleProducto); // UPDATE

    Optional<DetalleProductoEntity> buscarId(Integer id); // READ

    void eliminar(Integer id); // DELETE
}