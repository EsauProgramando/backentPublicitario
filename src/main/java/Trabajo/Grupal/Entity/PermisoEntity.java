package Trabajo.Grupal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "permisos")
public class PermisoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPermiso;

    private String nombres;

    @ManyToOne
    @JoinColumn(name = "IdPerfil")
    private PerfilEntity perfil;

    private String estado;

    public int getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    @Override
    public String toString() {
        return "PermisoEntity [idPermiso=" + idPermiso + ", nombres=" + nombres + ", perfil=" + perfil + ", estado="
                + estado + "]";
    }
}