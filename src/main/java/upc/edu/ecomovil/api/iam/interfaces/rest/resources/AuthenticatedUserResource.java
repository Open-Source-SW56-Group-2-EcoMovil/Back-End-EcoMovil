package upc.edu.ecomovil.api.iam.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String username, String email, String token) {
}