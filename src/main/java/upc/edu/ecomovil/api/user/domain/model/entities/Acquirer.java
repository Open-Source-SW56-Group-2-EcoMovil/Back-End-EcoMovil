package upc.edu.ecomovil.api.user.domain.model.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import upc.edu.ecomovil.api.user.domain.model.aggregates.Profile;
import upc.edu.ecomovil.api.user.domain.model.commands.CreateAcquirerCommand;


@Entity
public class Acquirer extends Profile {

    public Acquirer(String firstName, String lastName, String email, String phoneNumber) {
        super(firstName, lastName, email, phoneNumber);

    }

    public Acquirer() {
        super();
    }

    public Acquirer(CreateAcquirerCommand command) {
        super(command.firstName(), command.lastName(), command.email(), command.phoneNumber());

    }

}
