package upc.edu.ecomovil.api.vehicles.interfase.rest.resources;

public record VehicleResource(Long id, String details, Integer review, Boolean isAvailable, String imageUrl, Float lat, Float lng) {

}
