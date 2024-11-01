package upc.edu.ecomovil.api.user.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.ecomovil.api.user.domain.model.entities.Acquirer;


import java.util.Optional;

@Repository
public interface AcquirerRepository extends JpaRepository<Acquirer, Long> {

}
