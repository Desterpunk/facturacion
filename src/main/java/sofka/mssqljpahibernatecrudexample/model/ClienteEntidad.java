package sofka.mssqljpahibernatecrudexample.model;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTES")
public class ClienteEntidad {

    @Id
    private long id_cliente;
    private String nombre;
    private String direccion;
    private String telefono;

    public ClienteEntidad() {
    }

    public ClienteEntidad(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }


    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id) {
        this.id_cliente = id;
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
        return "ClienteEntidad{" +
                "id='" + id_cliente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
