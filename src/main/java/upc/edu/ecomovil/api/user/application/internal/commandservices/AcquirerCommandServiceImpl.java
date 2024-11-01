package upc.edu.ecomovil.api.user.application.internal.commandservices;

import org.springframework.stereotype.Service;
import upc.edu.ecomovil.api.user.domain.model.commands.CreateAcquirerCommand;
import upc.edu.ecomovil.api.user.domain.model.entities.Acquirer;
import upc.edu.ecomovil.api.user.domain.services.AcquirerCommandService;
import upc.edu.ecomovil.api.user.infrastructure.persistence.jpa.repositories.AcquirerRepository;

import java.util.Optional;

@Service
public class AcquirerCommandServiceImpl implements AcquirerCommandService {
    private final AcquirerRepository acquirerRepository;

    public AcquirerCommandServiceImpl(AcquirerRepository acquirerRepository) {
        this.acquirerRepository = acquirerRepository;
    }

    @Override
    public Optional<Acquirer> handle(CreateAcquirerCommand command){
        var acquirer = new Acquirer(command);
        acquirerRepository.save(acquirer);
        return Optional.of(acquirer);


    }

}
