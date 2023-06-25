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
@Table(name = "detalle_compra")
public class DetalleCompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "IdCompra")
    private CompraEntity compra;

    @ManyToOne
    @JoinColumn(name = "IdProveedor")
    private ProveedorEntity proveedor;

    @ManyToOne
    @JoinColumn(name = "IdProducto")
    private ProductoEntity producto;

    private int cantidad;
    private BigDecimal precioUnitario;
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CompraEntity getCompra() {
        return compra;
    }

    public void setCompra(CompraEntity compra) {
        this.compra = compra;
    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "DetalleCompraEntity [id=" + id + ", compra=" + compra + ", proveedor=" + proveedor + ", producto=" + producto
                + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", estado=" + estado + "]";
    }
}