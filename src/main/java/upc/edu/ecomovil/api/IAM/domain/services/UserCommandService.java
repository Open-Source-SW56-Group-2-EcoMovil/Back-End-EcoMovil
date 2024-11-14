package upc.edu.ecomovil.api.IAM.domain.services;

import org.apache.commons.lang3.tuple.ImmutablePair;
import upc.edu.ecomovil.api.IAM.domain.model.aggregates.User;
import upc.edu.ecomovil.api.IAM.domain.model.commands.SignInCommand;
import upc.edu.ecomovil.api.IAM.domain.model.commands.SignUpCommand;

import java.util.Optional;

/**
 * User command service
 * <p>
 *     This interface represents the service to handle user commands.
 * </p>
 */
public interface UserCommandService {
    /**
     * Handle sign in command
     * @param command the {@link SignInCommand} command
     * @return an {@link Optional} of {@link ImmutablePair} of {@link User} and {@link String}
     */
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);

    /**
     * Handle sign up command
     * @param command the {@link SignUpCommand} command
     * @return an {@link Optional} of {@link User} entity
     */
    Optional<User> handle(SignUpCommand command);
}
