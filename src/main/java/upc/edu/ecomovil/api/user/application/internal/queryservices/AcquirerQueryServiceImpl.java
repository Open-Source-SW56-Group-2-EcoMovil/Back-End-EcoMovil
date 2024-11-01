package upc.edu.ecomovil.api.user.application.internal.queryservices;

import org.springframework.stereotype.Service;
import upc.edu.ecomovil.api.user.domain.model.entities.Acquirer;
import upc.edu.ecomovil.api.user.domain.model.queries.Acquirer.GetAllAcquirerQuery;
import upc.edu.ecomovil.api.user.domain.services.AcquirerQueryService;
import upc.edu.ecomovil.api.user.infrastructure.persistence.jpa.repositories.AcquirerRepository;

import java.util.List;

@Service
public class AcquirerQueryServiceImpl implements AcquirerQueryService {
    private final AcquirerRepository acquirerRepository;

    public AcquirerQueryServiceImpl(AcquirerRepository acquirerRepository) {
        this.acquirerRepository = acquirerRepository;
    }


    @Override
    public List<Acquirer> handle(GetAllAcquirerQuery query) {
        return acquirerRepository.findAll();
    }

}
