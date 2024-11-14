package upc.edu.ecomovil.api.IAM.interfaces.rest.transform;

import upc.edu.ecomovil.api.IAM.domain.model.aggregates.User;
import upc.edu.ecomovil.api.IAM.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}
