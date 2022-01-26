package sofka.mssqljpahibernatecrudexample.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FACTURAS")
public class FacturaEntidad {
    @Id
    private long id;
    private Date fecha;
    private long id_cliente;

    public FacturaEntidad() {
    }

    public FacturaEntidad(Date fecha, long id_cliente) {
        this.fecha = fecha;
        this.id_cliente = id_cliente;
    }

    public long getId_factura() {
        return id;
    }

    public void setId_factura(long id) {
        this.id = id;
    }

    @Column(name = "FECHA", nullable = false)

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "ID_CLIENTE", nullable = false)

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "FacturaEntidad{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", id_cliente=" + id_cliente +
                '}';
    }
}
