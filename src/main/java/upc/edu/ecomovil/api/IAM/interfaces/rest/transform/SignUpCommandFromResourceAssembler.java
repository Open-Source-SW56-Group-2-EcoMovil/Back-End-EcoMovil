package upc.edu.ecomovil.api.IAM.interfaces.rest.transform;

import upc.edu.ecomovil.api.IAM.domain.model.commands.SignUpCommand;
import upc.edu.ecomovil.api.IAM.domain.model.entities.Role;
import upc.edu.ecomovil.api.IAM.interfaces.rest.resources.SignUpResource;

import java.util.*;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() != null ? resource.roles().stream().map(name -> Role.toRoleFromName(name)).toList() : new ArrayList<Role>();
        return new SignUpCommand(resource.username(), resource.password(), roles);
    }
}
