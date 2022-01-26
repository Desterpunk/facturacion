package sofka.mssqljpahibernatecrudexample.model;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORIAS")
public class CategoriaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_categoria;
    private String descripcion;

    public CategoriaEntidad() {
    }

    public CategoriaEntidad(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(long id) {
        this.id_categoria = id;
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
                "id=" + id_categoria +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
