package sofka.mssqljpahibernatecrudexample.model;

import javax.persistence.*;

@Entity
@Table(name = "PROVEEDORES")
public class ProveedorEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_proveedor;
    private String nombre;
    private String direccion;
    private String telefono;

    public ProveedorEntidad() {
    }

    public ProveedorEntidad(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public long getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(long id) {
        this.id_proveedor = id;
    }

    @Column(name = "NOMBRE", nullable = false)

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "DIRECCION", nullable = false)

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "TELEFONO", nullable = false)

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ProveedorEntidad{" +
                "id=" + id_proveedor +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
