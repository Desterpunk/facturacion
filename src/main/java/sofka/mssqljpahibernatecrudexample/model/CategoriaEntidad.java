package sofka.mssqljpahibernatecrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIAS")
public class CategoriaEntidad {

    @Id
    private long id;
    private String descripcion;

    public CategoriaEntidad() {
    }

    public CategoriaEntidad(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getId_categoria() {
        return id;
    }

    public void setId_categoria(long id) {
        this.id = id;
    }

    @Column(name = "DESCRIPCION", nullable = false)

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "CategoriaEntidad{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
