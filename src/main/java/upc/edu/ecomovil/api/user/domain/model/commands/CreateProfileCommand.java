package upc.edu.ecomovil.api.user.domain.model.commands;

public record CreateProfileCommand(String firstName, String lastName, String email, String phoneNumber) {

}
