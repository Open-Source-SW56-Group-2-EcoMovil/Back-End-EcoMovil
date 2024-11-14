package upc.edu.ecomovil.api.IAM.application.internal.commandservices;

import org.springframework.stereotype.Service;
import upc.edu.ecomovil.api.IAM.domain.model.commands.SeedRolesCommand;
import upc.edu.ecomovil.api.IAM.domain.model.entities.Role;
import upc.edu.ecomovil.api.IAM.domain.model.valueobjects.Roles;
import upc.edu.ecomovil.api.IAM.domain.services.RoleCommandService;
import upc.edu.ecomovil.api.IAM.infrastructure.persistence.jpa.repositories.RoleRepository;

import java.util.Arrays;

/**
 * Implementation of {@link RoleCommandService} to handle {@link SeedRolesCommand}
 */
@Service
public class RoleCommandServiceImpl implements RoleCommandService { private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * This method will handle the {@link SeedRolesCommand} and will create the roles if not exists
     * @param command {@link SeedRolesCommand}
     * @see SeedRolesCommand
     */
    @Override
    public void handle(SeedRolesCommand command) {
        Arrays.stream(Roles.values()).forEach(role -> {
            if(!roleRepository.existsByName(role)) {
                roleRepository.save(new Role(Roles.valueOf(role.name())));
            }
        } );
    }
}
