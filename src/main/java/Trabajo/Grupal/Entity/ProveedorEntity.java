package Trabajo.Grupal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor")
public class ProveedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProveedor;
    private String nomCompania;
    private String direccion;
    private String telefono;
    private String correo;
    private String NTarjeta;
    private String nombre;
    private String RUC;
    private String estado;

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNomCompania() {
        return nomCompania;
    }

    public void setNomCompania(String nomCompania) {
        this.nomCompania = nomCompania;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNTarjeta() {
        return NTarjeta;
    }

    public void setNTarjeta(String NTarjeta) {
        this.NTarjeta = NTarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ProveedorEntity [idProveedor=" + idProveedor + ", nomCompania=" + nomCompania + ", direccion=" + direccion +
                ", telefono=" + telefono + ", correo=" + correo + ", NTarjeta=" + NTarjeta + ", nombre=" + nombre +
                ", RUC=" + RUC + ", estado=" + estado + "]";
    }
}

