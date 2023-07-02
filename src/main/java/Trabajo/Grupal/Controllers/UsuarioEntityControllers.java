package Trabajo.Grupal.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Trabajo.Grupal.Entity.UsuarioEntity;
import Trabajo.Grupal.Service.IUsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class UsuarioEntityControllers {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/usuario")
    public List<UsuarioEntity> buscarTodos() {
        return usuarioService.buscarTodos();
    }

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
    @PostMapping("/usuario")
    public UsuarioEntity guardar(@RequestBody UsuarioEntity usuario) {
    	
    	UsuarioEntity nuevoUser = null;
    
    	UsuarioEntity user = new UsuarioEntity(usuario.getNombre(),usuario.getApellido(), usuario.getCorreo(),
    			passwordEncoder.encode(usuario.getContrasena()),usuario.getDNI(), 
    			usuario.getCelular(),usuario.getSucursal(),usuario.getUsername(),usuario.getDireccion(),usuario.getPerfil(),usuario.getEstado());
    	
    	nuevoUser = usuarioService.guardar(user);
        return nuevoUser;
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UsuarioEntity usuario, BindingResult result) {
    	
    	 UsuarioEntity login = null;
    	    login = usuarioService.findByUsername(usuario.getUsername());
    	    Map<String, Object> response = new HashMap<>();
    	    if (result.hasErrors()) {
    	        List<String> errors = result.getFieldErrors().stream()
    	                .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
    	                .collect(Collectors.toList());

    	        response.put("errors", errors);
    	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
    	    }

    	    if (login == null) {
    	        response.put("mensaje", "Usuario y/o contraseña incorrectos");
    	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    	    }

    	    if (passwordEncoder.matches(usuario.getContrasena(), login.getContrasena())) {
    	        response.put("mensaje", "Inicio de sesión exitoso");
    	        response.put("usuario", login);
    	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    	    } else {
    	        response.put("mensaje", "Usuario y/o contraseña incorrectos");
    	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    	    }
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<?> modificar(@Valid @RequestBody UsuarioEntity usuario,BindingResult result, @PathVariable Integer id) {
    	Map<String, Object> response = new HashMap<>();
    	   	UsuarioEntity usuarioUpdate = null;
    	UsuarioEntity usuarioActual = usuarioService.findById(id);
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		if (usuarioActual == null) {
			response.put("mensaje", "Error no se pudo editar, el usuario ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {

			usuarioActual.setUsername(usuario.getUsername());

			if (usuario.getNombre() != null) {
				usuarioActual.setNombre(usuario.getNombre());
				}

			if (usuario.getApellido() != null) {
				usuarioActual.setApellido(usuario.getApellido());
			}
			if (usuario.getCorreo() != null) {
				usuarioActual.setCorreo(usuario.getCorreo());
			}

			if (usuario.getCelular() != null) {
				usuarioActual.setCelular(usuario.getCelular());
			}
			if (usuario.getContrasena() != null) {
				usuarioActual.setCelular(usuario.getContrasena());
			}

			usuarioUpdate = usuarioService.guardar(usuarioActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el cliente en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
    	response.put("mensaje", "El usuario ha sido actualizado con 'exito!");
		response.put("usuario", usuarioUpdate);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);// 201
    }

    @GetMapping("/usuario/{id}")
    public Optional<UsuarioEntity> buscarId(@PathVariable("id") Integer id) {
        return usuarioService.buscarId(id);
    }

    @DeleteMapping("/usuario/{id}")
    public String eliminar(@PathVariable Integer id) {
        usuarioService.eliminar(id);
        return "Usuario eliminado";
    }
}