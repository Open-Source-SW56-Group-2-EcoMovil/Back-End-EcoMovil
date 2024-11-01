package upc.edu.ecomovil.api.vehicle.infrastructure.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.ecomovil.api.vehicle.domain.model.entities.Vehicle;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByType(String type);
}
