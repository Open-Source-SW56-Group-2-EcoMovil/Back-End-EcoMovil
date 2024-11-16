package upc.edu.ecomovil.api.reservations.application.internal.commandservices;

import org.springframework.stereotype.Service;
import upc.edu.ecomovil.api.reservations.application.internal.outboundservices.acl.ExternalProfileService;
import upc.edu.ecomovil.api.reservations.application.internal.outboundservices.acl.ExternalVehicleService;
import upc.edu.ecomovil.api.reservations.domain.model.aggregates.Reservation;
import upc.edu.ecomovil.api.reservations.domain.model.commands.CreateReservationCommand;
import upc.edu.ecomovil.api.reservations.domain.services.ReservationCommandService;
import upc.edu.ecomovil.api.reservations.infrastructure.persistence.jpa.repositories.ReservationRepository;

import java.util.Optional;

@Service
public class ReservationCommandServiceImpl implements ReservationCommandService {
    private final ReservationRepository reservationRepository;
    private final ExternalProfileService externalProfileService;
    private final ExternalVehicleService externalVehicleService;

    public ReservationCommandServiceImpl(ReservationRepository reservationRepository, ExternalProfileService externalProfileService, ExternalVehicleService externalVehicleService) {
        this.reservationRepository = reservationRepository;
        this.externalProfileService = externalProfileService;
        this.externalVehicleService = externalVehicleService;
    }

    @Override
    public Optional<Reservation> handle(CreateReservationCommand command) {
        var profile = externalProfileService.fetchProfileById(command.profileId());
        if (profile.isEmpty()) {
            throw new IllegalArgumentException("El perfil con el ID especificado no existe");
        }

        var vehicle = externalVehicleService.fetchVehicleById(command.vehicleId());
        if (vehicle.isEmpty()) {
            throw new IllegalArgumentException("El vehículo con el ID especificado no existe");
        }

        var reservation = new Reservation(command, vehicle.get(), profile.get());
        reservationRepository.save(reservation);
        return Optional.of(reservation);
    }
}
/**
 @Override
 public Optional<Vehicle> handle(CreateVehicleCommand command) {

 var student = externalStudentService.fetchStudentById(command.studentId());
 if (student.isEmpty()) {
 throw new IllegalArgumentException("El estudiante con el ID especificado no existe");
 }


 var vehicle = new Vehicle(command, student.get());
 vehicleRepository.save(vehicle);
 return Optional.of(vehicle);
 }
 }
 */