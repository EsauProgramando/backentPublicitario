package Trabajo.Grupal.Entity;
import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "venta")
public class VentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;
    
    @ManyToOne
    @JoinColumn(name = "IdUsuario")
    private UsuarioEntity usuario;
    
    @ManyToOne
    @JoinColumn(name = "IdDistrito")
    private DistritoEntity distrito;
    
    private String tipoVenta;
    private String tipoComprobante;
    private Date fechaHora;
    private BigDecimal total;
    private String estado;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

    public DistritoEntity getDistrito() {
		return distrito;
	}

	public void setDistrito(DistritoEntity distrito) {
		this.distrito = distrito;
	}

	@Override
	public String toString() {
		return "VentaEntity [idVenta=" + idVenta + ", usuario=" + usuario + ", distrito=" + distrito + ", tipoVenta="
				+ tipoVenta + ", tipoComprobante=" + tipoComprobante + ", fechaHora=" + fechaHora + ", total=" + total
				+ ", estado=" + estado + "]";
	}

	
}