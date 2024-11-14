package upc.edu.ecomovil.api.IAM.interfaces.rest.transform;

import upc.edu.ecomovil.api.IAM.domain.model.commands.SignInCommand;
import upc.edu.ecomovil.api.IAM.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}
