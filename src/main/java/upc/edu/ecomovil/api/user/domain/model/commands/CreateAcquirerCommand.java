package upc.edu.ecomovil.api.user.domain.model.commands;

public record CreateAcquirerCommand(String firstName, String lastName, String email, String phoneNumber) {
}
