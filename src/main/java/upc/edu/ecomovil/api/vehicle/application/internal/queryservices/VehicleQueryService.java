package upc.edu.ecomovil.api.vehicle.application.internal.queryservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.ecomovil.api.vehicle.domain.model.entities.Vehicle;
import upc.edu.ecomovil.api.vehicle.infrastructure.repositories.jpa.VehicleRepository;

import java.util.List;

@Service
public class VehicleQueryService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
    }

    public List<Vehicle> getVehiclesByType(String type) {
        return vehicleRepository.findByType(type);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
}
