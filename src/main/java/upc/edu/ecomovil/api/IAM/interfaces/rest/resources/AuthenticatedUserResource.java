package upc.edu.ecomovil.api.IAM.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String username, String token) {
}