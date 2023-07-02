package Trabajo.Grupal.Service;

import java.util.List;
import java.util.Optional;
import Trabajo.Grupal.Entity.UsuarioEntity;

public interface IUsuarioService {
    List<UsuarioEntity> buscarTodos(); // READ

    UsuarioEntity guardar(UsuarioEntity usuario); // CREATE

    void modificar(UsuarioEntity usuario); // UPDATE

    Optional<UsuarioEntity> buscarId(Integer id); // READ

    void eliminar(Integer id); // DELETE
    public UsuarioEntity findById(Integer id);
    
    public UsuarioEntity findByUsername(String username);
}