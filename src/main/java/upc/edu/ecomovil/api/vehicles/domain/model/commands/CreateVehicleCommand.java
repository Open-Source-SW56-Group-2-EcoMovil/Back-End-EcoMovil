package upc.edu.ecomovil.api.vehicles.domain.model.commands;

public record CreateVehicleCommand(String type, String name, Integer year, Integer review, Boolean isAvailable, String imageUrl, Float lat, Float lng) {

}
