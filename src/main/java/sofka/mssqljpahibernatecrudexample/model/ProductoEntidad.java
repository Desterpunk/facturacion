package sofka.mssqljpahibernatecrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTOS")
public class ProductoEntidad {

    @Id
    private long id_producto;
    private String descripcion;
    private long precio;
    private long id_categoria;
    private long id_proveedor;

    public ProductoEntidad() {
    }

    public ProductoEntidad(String descripcion, long precio, long id_categoria, long id_proveedor) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.id_categoria = id_categoria;
        this.id_proveedor = id_proveedor;
    }

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id) {
        this.id_producto = id;
    }

    @Column(name = "DESCRIPCION", nullable = false)

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "PRECIO", nullable = false)

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    @Column(name = "ID_CATEGORIA", nullable = false)

    public long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(long id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Column(name = "ID_PROVEEDOR", nullable = false)

    public long getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(long id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    @Override
    public String toString() {
        return "ProductoEntidad{" +
                "id=" + id_producto +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", id_categoria=" + id_categoria +
                ", id_proveedor=" + id_proveedor +
                '}';
    }
}
