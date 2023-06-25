package Trabajo.Grupal.Service;

import java.util.List;
import java.util.Optional;

import Trabajo.Grupal.Entity.DetalleVentaEntity;

public interface IDetalleVentaService {
    List<DetalleVentaEntity> buscarTodos(); // READ

    void guardar(DetalleVentaEntity detalleVenta); // CREATE

    void modificar(DetalleVentaEntity detalleVenta); // UPDATE

    Optional<DetalleVentaEntity> buscarId(Integer id); // READ

    void eliminar(Integer id); // DELETE
}