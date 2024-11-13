package upc.edu.ecomovil.api.vehicles.interfase.rest.resources;

public record CreateVehicleResource(String type, String name, Integer year, Integer review, Boolean isAvailable, String imageUrl, Float lat, Float lng) {
}
