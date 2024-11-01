package upc.edu.ecomovil.api.user.domain.services;

import upc.edu.ecomovil.api.user.domain.model.commands.CreateAcquirerCommand;
import upc.edu.ecomovil.api.user.domain.model.entities.Acquirer;

import java.util.Optional;

public interface AcquirerCommandService {
    Optional<Acquirer> handle(CreateAcquirerCommand command);
}
