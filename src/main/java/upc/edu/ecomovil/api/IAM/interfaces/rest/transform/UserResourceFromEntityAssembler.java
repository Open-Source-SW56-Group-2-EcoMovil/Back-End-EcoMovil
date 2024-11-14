package upc.edu.ecomovil.api.IAM.interfaces.rest.transform;

import upc.edu.ecomovil.api.IAM.domain.model.aggregates.User;
import upc.edu.ecomovil.api.IAM.interfaces.rest.resources.UserResource;
import upc.edu.ecomovil.api.IAM.domain.model.entities.Role;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(user.getId(), user.getUsername(), roles);
    }
}