package Trabajo.Grupal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "provincia")
public class ProvinciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProvincia;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idDepartamento")
    private DepartamentoEntity departamento;

    private String estado;

    public ProvinciaEntity() {
        // Constructor vacío requerido por JPA
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DepartamentoEntity getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoEntity departamento) {
        this.departamento = departamento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ProvinciaEntity [idProvincia=" + idProvincia + ", nombre=" + nombre + ", departamento=" + departamento
                + ", estado=" + estado + "]";
    }
}
