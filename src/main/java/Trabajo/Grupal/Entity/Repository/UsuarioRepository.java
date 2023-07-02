package Trabajo.Grupal.Entity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;



import Trabajo.Grupal.Entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
	public UsuarioEntity findByUsername(String username);
}