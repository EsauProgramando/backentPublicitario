package Trabajo.Grupal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_venta")
public class DetalleVentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "IdVenta")
    private VentaEntity venta;
    
    private int cantidad;
    private BigDecimal precio;
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VentaEntity getVenta() {
        return venta;
    }

    public void setVenta(VentaEntity venta) {
        this.venta = venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "DetalleVentaEntity [id=" + id + ", venta=" + venta + ", cantidad=" + cantidad + ", precio=" + precio
                + ", estado=" + estado + "]";
    }
}