package sofka.mssqljpahibernatecrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sofka.mssqljpahibernatecrudexample.model.ClienteEntidad;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntidad, Long> {
}
