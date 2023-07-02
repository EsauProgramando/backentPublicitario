package Trabajo.Grupal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "compra")
public class CompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompra;
    
    private String descripcion;
    private BigDecimal total;
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name = "IdUsuario")
    private UsuarioEntity usuario;
    
    @ManyToOne
    @JoinColumn(name = "IdDistrito")
    private DistritoEntity distrito;
    
    public DistritoEntity getDistrito() {
		return distrito;
	}

	public void setDistrito(DistritoEntity distrito) {
		this.distrito = distrito;
	}

	private String estado;

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

	@Override
	public String toString() {
		return "CompraEntity [idCompra=" + idCompra + ", descripcion=" + descripcion + ", total=" + total + ", fecha="
				+ fecha + ", usuario=" + usuario + ", distrito=" + distrito + ", estado=" + estado + "]";
	}

    
}