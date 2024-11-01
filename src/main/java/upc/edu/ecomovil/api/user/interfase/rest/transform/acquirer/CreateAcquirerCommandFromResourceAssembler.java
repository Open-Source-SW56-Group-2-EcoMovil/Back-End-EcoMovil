package upc.edu.ecomovil.api.user.interfase.rest.transform.acquirer;

import upc.edu.ecomovil.api.user.domain.model.commands.CreateAcquirerCommand;
import upc.edu.ecomovil.api.user.interfase.rest.resources.acquirer.CreateAcquirerResource;

public class CreateAcquirerCommandFromResourceAssembler {
    public static CreateAcquirerCommand toCommandFromResource(CreateAcquirerResource resource){
        return new CreateAcquirerCommand(resource.firstName(), resource.lastName(), resource.email(), resource.phoneNumber());
    }
}
