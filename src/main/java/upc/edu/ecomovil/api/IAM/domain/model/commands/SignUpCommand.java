package upc.edu.ecomovil.api.IAM.domain.model.commands;

import upc.edu.ecomovil.api.IAM.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}