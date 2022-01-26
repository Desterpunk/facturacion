package sofka.mssqljpahibernatecrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sofka.mssqljpahibernatecrudexample.model.ProductoEntidad;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntidad,Long> {
}
