package upc.edu.ecomovil.api.IAM.interfaces.rest.transform;

import upc.edu.ecomovil.api.IAM.domain.model.entities.Role;
import upc.edu.ecomovil.api.IAM.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}