package Trabajo.Grupal.Service;

import java.util.List;
import java.util.Optional;

import Trabajo.Grupal.Entity.VentaEntity;

public interface IVentaService {
    List<VentaEntity> buscarTodos(); // READ

    void guardar(VentaEntity venta); // CREATE

    void modificar(VentaEntity venta); // UPDATE

    Optional<VentaEntity> buscarId(Integer id); // READ

    void eliminar(Integer id); // DELETE
}