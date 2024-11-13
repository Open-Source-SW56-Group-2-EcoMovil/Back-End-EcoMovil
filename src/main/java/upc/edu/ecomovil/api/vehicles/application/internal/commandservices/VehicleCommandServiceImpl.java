package upc.edu.ecomovil.api.vehicles.application.internal.commandservices;

import org.springframework.stereotype.Service;
import upc.edu.ecomovil.api.vehicles.domain.model.aggregates.Vehicle;
import upc.edu.ecomovil.api.vehicles.domain.model.commands.CreateVehicleCommand;
import upc.edu.ecomovil.api.vehicles.domain.services.VehicleCommandService;
import upc.edu.ecomovil.api.vehicles.infraestructure.persistence.jpa.repositories.VehicleRepository;

import java.util.Optional;

@Service
public class VehicleCommandServiceImpl implements VehicleCommandService {
    private final VehicleRepository vehicleRepository;

    public VehicleCommandServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Optional<Vehicle> handle(CreateVehicleCommand command) {
        var vehicle = new Vehicle(command);
        vehicleRepository.save(vehicle);
        return Optional.of(vehicle);
    }
}


//@Service
//public class AcquirerCommandServiceImpl implements AcquirerCommandService {
//    private final AcquirerRepository acquirerRepository;
//
//    public AcquirerCommandServiceImpl(AcquirerRepository acquirerRepository) {
//        this.acquirerRepository = acquirerRepository;
//    }
//
//    @Override
//    public Optional<Acquirer> handle(CreateAcquirerCommand command){
//        var acquirer = new Acquirer(command);
//        acquirerRepository.save(acquirer);
//        return Optional.of(acquirer);
//
//
//    }
//
//}