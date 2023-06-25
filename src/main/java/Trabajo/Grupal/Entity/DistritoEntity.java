package Trabajo.Grupal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "distrito")
public class DistritoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDistrito;
    private String nombre;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "IdProvincia")
    private ProvinciaEntity provincia;

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ProvinciaEntity getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaEntity provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "DistritoEntity [idDistrito=" + idDistrito + ", nombre=" + nombre + ", estado=" + estado + "]";
    }
}
