package Trabajo.Grupal.Service;

import java.util.List;
import java.util.Optional;

import Trabajo.Grupal.Entity.ProductoEntity;

public interface IProductoService {
    List<ProductoEntity> buscarTodos(); // READ

    void guardar(ProductoEntity producto); // CREATE

    void modificar(ProductoEntity producto); // UPDATE

    Optional<ProductoEntity> buscarId(Integer id); // READ
    public ProductoEntity findById(Integer id);

    void eliminar(Integer id); // DELETE
}