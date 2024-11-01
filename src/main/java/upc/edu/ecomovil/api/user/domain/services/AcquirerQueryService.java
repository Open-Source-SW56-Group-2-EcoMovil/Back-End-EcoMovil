package upc.edu.ecomovil.api.user.domain.services;

import upc.edu.ecomovil.api.user.domain.model.entities.Acquirer;
import upc.edu.ecomovil.api.user.domain.model.queries.Acquirer.GetAllAcquirerQuery;

import java.util.List;

public interface AcquirerQueryService {
    List<Acquirer> handle(GetAllAcquirerQuery query);
}
