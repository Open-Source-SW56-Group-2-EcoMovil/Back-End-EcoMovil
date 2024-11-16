package upc.edu.ecomovil.api.reservations.domain.services;

import upc.edu.ecomovil.api.reservations.domain.model.aggregates.Reservation;
import upc.edu.ecomovil.api.reservations.domain.model.commands.CreateReservationCommand;

import java.util.Optional;

public interface ReservationCommandService {
    Optional<Reservation> handle (CreateReservationCommand command);
 }
