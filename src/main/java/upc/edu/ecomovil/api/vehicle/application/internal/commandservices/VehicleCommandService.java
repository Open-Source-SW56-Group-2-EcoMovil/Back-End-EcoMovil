package upc.edu.ecomovil.api.vehicle.application.internal.commandservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.ecomovil.api.vehicle.domain.model.commands.CreateVehicleCommand;
import upc.edu.ecomovil.api.vehicle.domain.model.entities.Vehicle;
import upc.edu.ecomovil.api.vehicle.infrastructure.repositories.jpa.VehicleRepository;

@Service
public class VehicleCommandService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle createVehicle(CreateVehicleCommand command) {
        Vehicle vehicle = new Vehicle();
        vehicle.setType(command.getType());
        vehicle.setBrand(command.getBrand());
        vehicle.setModel(command.getModel());
        vehicle.setYear(command.getYear());
        vehicle.setFeatures(command.getFeatures());
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    public Vehicle updateVehicle(Long id, CreateVehicleCommand command) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.setType(command.getType());
        vehicle.setBrand(command.getBrand());
        vehicle.setModel(command.getModel());
        vehicle.setYear(command.getYear());
        vehicle.setFeatures(command.getFeatures());
        return vehicleRepository.save(vehicle);
    }
}
