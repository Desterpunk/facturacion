package sofka.mssqljpahibernatecrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sofka.mssqljpahibernatecrudexample.model.FacturaEntidad;

@Repository
public interface FacturaRepository extends JpaRepository<FacturaEntidad, Long> {
}
