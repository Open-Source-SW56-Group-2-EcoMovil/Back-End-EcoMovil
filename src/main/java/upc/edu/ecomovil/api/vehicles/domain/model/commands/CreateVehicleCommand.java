package upc.edu.ecomovil.api.vehicles.domain.model.commands;

public record CreateVehicleCommand(String type, String name, Integer year, Double sellingPrice, Integer rentalPrice, Integer review, Boolean isAvailable, String imageUrl, Float lat, Float lng) {

}
