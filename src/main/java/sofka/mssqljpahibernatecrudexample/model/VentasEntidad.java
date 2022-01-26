package sofka.mssqljpahibernatecrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "VENTAS")
public class VentasEntidad {
    @Id
    private long id;
    private long id_factura;
    private long id_producto;
    private long cantidad;

    public VentasEntidad() {
    }

    public VentasEntidad(long id, long id_factura, long id_producto, long cantidad) {
        this.id = id;
        this.id_factura = id_factura;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }

    public long getId_venta() {
        return id;
    }

    public void setId_venta(long id) {
        this.id = id;
    }

    @Column(name = "ID_FACTURA", nullable = false)

    public long getId_factura() {
        return id_factura;
    }

    public void setId_factura(long id_factura) {
        this.id_factura = id_factura;
    }

    @Column(name = "ID_PRODUCTO", nullable = false)

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }

    @Column(name = "CANTIDAD", nullable = false)

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "VentasEntidad{" +
                "id=" + id +
                ", id_factura='" + id_factura + '\'' +
                ", id_producto='" + id_producto + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}