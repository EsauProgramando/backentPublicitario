package Trabajo.Grupal.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    private String nombres;

    @ManyToOne
    @JoinColumn(name = "IdMarca")
    private MarcaEntity marca;

    @ManyToOne
    @JoinColumn(name = "IdCategoria")
    private CategoriaEntity categoria;

    private int cantidad;
    private Date fechaCaducidad;
    private String productoImg;
    private String estado;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public MarcaEntity getMarca() {
        return marca;
    }

    public void setMarca(MarcaEntity marca) {
        this.marca = marca;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProductoImg() {
		return productoImg;
	}

	public void setProductoImg(String productoImg) {
		this.productoImg = productoImg;
	}

	@Override
    public String toString() {
        return "ProductoEntity [idProducto=" + idProducto + ", nombres=" + nombres + ", marca=" + marca
                + ", categoria=" + categoria + ", cantidad=" + cantidad + ", fechaCaducidad=" + fechaCaducidad
                + ", estado=" + estado + "]";
    }
}