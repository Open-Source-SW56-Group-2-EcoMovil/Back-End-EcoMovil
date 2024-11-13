package upc.edu.ecomovil.api.vehicles.interfase.rest.resources;

public record CreateVehicleResource(String type, String name, Integer year, Integer review, Double price, Boolean isAvailable, String imageUrl, Float lat, Float lng) {
}
