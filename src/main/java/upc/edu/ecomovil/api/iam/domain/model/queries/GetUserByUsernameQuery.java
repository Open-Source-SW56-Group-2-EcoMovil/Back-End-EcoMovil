/**
 * Get user by username query
 * <p>
 *     This class represents the query to get a user by its username.
 * </p>
 * @param username the username of the user
 */
package upc.edu.ecomovil.api.iam.domain.model.queries;

public record GetUserByUsernameQuery(String username) {
}