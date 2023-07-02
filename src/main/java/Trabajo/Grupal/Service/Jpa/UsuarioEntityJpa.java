package Trabajo.Grupal.Service.Jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Trabajo.Grupal.Entity.UsuarioEntity;
import Trabajo.Grupal.Entity.Repository.UsuarioRepository;
import Trabajo.Grupal.Service.IUsuarioService;

@Service
public class 	UsuarioEntityJpa implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> buscarTodos() {
        return usuarioRepository.findAll();
    }



    @Override
    @Transactional
    public void modificar(UsuarioEntity usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Optional<UsuarioEntity> buscarId(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }



	@Override
	@Transactional
	public UsuarioEntity guardar(UsuarioEntity usuario) {
		   
		return usuarioRepository.save(usuario);
	}



	@Override
	@Transactional(readOnly = true)
	public UsuarioEntity findByUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}



	@Override
	@Transactional(readOnly = true)
	public UsuarioEntity findById(Integer id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).orElse(null);
	}
}