package upc.edu.ecomovil.api.vehicles.interfase.rest.resources;

public record VehicleResource(String type, String name, Integer year, Integer review,Double priceRent, Double priceSell, Boolean isAvailable, String imageUrl, Float lat, Float lng, String description, Long studentId) {

}
