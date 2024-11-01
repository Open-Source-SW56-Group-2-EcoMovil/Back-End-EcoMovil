package upc.edu.ecomovil.api.user.interfase.rest.transform.acquirer;

import upc.edu.ecomovil.api.user.domain.model.entities.Acquirer;
import upc.edu.ecomovil.api.user.interfase.rest.resources.acquirer.AcquirerResource;

public class AcquirerResourceFromEntityAssembler {
    public static AcquirerResource toResourceFromEntity(Acquirer acquirer){
        return new AcquirerResource(acquirer.getId(), acquirer.getFullName(), acquirer.getEmail(), acquirer.getPhoneNumber());
    }
}
