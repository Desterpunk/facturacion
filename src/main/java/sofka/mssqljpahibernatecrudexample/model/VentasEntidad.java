package sofka.mssqljpahibernatecrudexample.model;

import javax.persistence.*;

@Entity
@Table(name = "VENTAS")
public class VentasEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_venta;
    private long id_factura;
    private long id_producto;
    private long cantidad;

    public VentasEntidad() {
    }

    public VentasEntidad(long id_factura, long id_producto, long cantidad) {
        this.id_factura = id_factura;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }

    public long getId_venta() {
        return id_venta;
    }

    public void setId_venta(long id) {
        this.id_venta = id;
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
                "id=" + id_venta +
                ", id_factura='" + id_factura + '\'' +
                ", id_producto='" + id_producto + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
