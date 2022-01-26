package sofka.mssqljpahibernatecrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sofka.mssqljpahibernatecrudexample.model.VentasEntidad;

@Repository
public interface VentaRepository extends JpaRepository<VentasEntidad,Long> {
}
