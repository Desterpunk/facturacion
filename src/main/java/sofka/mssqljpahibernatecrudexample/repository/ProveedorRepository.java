package sofka.mssqljpahibernatecrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sofka.mssqljpahibernatecrudexample.model.ProveedorEntidad;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntidad, Long> {
}
