package upc.edu.ecomovil.api.reservations.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.ecomovil.api.reservations.domain.model.aggregates.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    //Aqui incluyo aquellos metodos que no estan en el JpaRepository

}

