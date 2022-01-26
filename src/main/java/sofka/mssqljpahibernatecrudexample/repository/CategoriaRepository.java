package sofka.mssqljpahibernatecrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sofka.mssqljpahibernatecrudexample.model.CategoriaEntidad;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntidad,Long> {
}
