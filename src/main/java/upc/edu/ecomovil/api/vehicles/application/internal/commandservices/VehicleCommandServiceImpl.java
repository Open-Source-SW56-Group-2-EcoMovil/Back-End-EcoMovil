package upc.edu.ecomovil.api.vehicles.application.internal.commandservices;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import upc.edu.ecomovil.api.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import upc.edu.ecomovil.api.vehicles.domain.model.aggregates.Vehicle;
import upc.edu.ecomovil.api.vehicles.domain.model.commands.CreateVehicleCommand;
import upc.edu.ecomovil.api.vehicles.domain.model.commands.DeleteVehicleCommand;
import upc.edu.ecomovil.api.vehicles.domain.services.VehicleCommandService;
import upc.edu.ecomovil.api.vehicles.infraestructure.persistence.jpa.repositories.VehicleRepository;

import java.util.Optional;

@Service
public class VehicleCommandServiceImpl implements VehicleCommandService {
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;

    public VehicleCommandServiceImpl(VehicleRepository vehicleRepository, UserRepository userRepository) {
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Vehicle> handle(CreateVehicleCommand command) {
        // Obtener usuario actual del contexto de seguridad
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var username = authentication.getName();
        var currentUser = userRepository.findByUsername(username)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        // Crear vehículo con el propietario
        var vehicle = new Vehicle(command, currentUser);
        vehicleRepository.save(vehicle);
        return Optional.of(vehicle);
    }

    @Override
    public void handle(DeleteVehicleCommand command) {
        var vehicleId = command.vehicleId();
        var vehicle = vehicleRepository.findById(vehicleId)
            .orElseThrow(() -> new IllegalArgumentException("Vehicle with ID " + vehicleId + " does not exist"));
        
        // Obtener usuario actual
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var username = authentication.getName();
        var currentUser = userRepository.findByUsername(username)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        // Verificar si es el propietario O es admin
        boolean isOwner = vehicle.getOwner().getId().equals(currentUser.getId());
        boolean isAdmin = currentUser.getRoles().stream()
            .anyMatch(role -> role.getName().name().equals("ADMIN"));
        
        if (!isOwner && !isAdmin) {
            throw new IllegalArgumentException("Access denied: Only the vehicle owner or admin can delete this vehicle");
        }
        
        vehicleRepository.deleteById(vehicleId);
    }
}