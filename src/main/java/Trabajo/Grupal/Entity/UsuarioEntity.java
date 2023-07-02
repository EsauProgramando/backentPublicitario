package Trabajo.Grupal.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String DNI;
    private String celular;
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "IdPerfil")
    private PerfilEntity perfil;

    @ManyToOne
    @JoinColumn(name = "IdSucursal")
    private SucursalEntity sucursal;
    
	@NotEmpty(message = "no puede estar vacio")
	@Column(unique = true, length = 20)
	private String username;

    private String estado;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public PerfilEntity getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    public SucursalEntity getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalEntity sucursal) {
		this.sucursal = sucursal;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UsuarioEntity(String nombre, String apellido, String correo, String contrasena, String dNI, String celular,
			SucursalEntity sucursal,
			String username,String direccion, PerfilEntity perfil, String estado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasena = contrasena;
		DNI = dNI;
		this.celular = celular;
		this.direccion = direccion;
		this.perfil = perfil;
		this.sucursal = sucursal;
		this.username = username;
		this.estado = estado;
	}

	public UsuarioEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UsuarioEntity [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", correo="
				+ correo + ", contrasena=" + contrasena + ", DNI=" + DNI + ", celular=" + celular + ", direccion="
				+ direccion + ", perfil=" + perfil + ", sucursal=" + sucursal + ", estado=" + estado + "]";
	}

	
}