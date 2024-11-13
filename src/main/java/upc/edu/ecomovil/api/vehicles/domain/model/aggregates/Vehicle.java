package upc.edu.ecomovil.api.vehicles.domain.model.aggregates;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import upc.edu.ecomovil.api.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import upc.edu.ecomovil.api.vehicles.domain.model.commands.CreateVehicleCommand;
import upc.edu.ecomovil.api.vehicles.domain.model.valueobjects.Details;
import upc.edu.ecomovil.api.vehicles.domain.model.valueobjects.Review;

@Entity
public class Vehicle extends AuditableAbstractAggregateRoot<Vehicle> {

    @Embedded
    private Details details;

    @Embedded
    private Review review;

    @Getter
    private Boolean isAvailable;

    @Getter
    private String ImageUrl;

    @Getter
    private Float lat; //latitud

    @Getter
    private Float lng; //longitud



    public Vehicle(String type, String name, Integer year, Double sellingPrice, Integer rentalPrice, Integer review, Boolean isAvailable, String imageUrl, Float lat, Float lng) {
        this.details = new Details(type, name, year, sellingPrice, rentalPrice);
        this.review = new Review(review);
        this.isAvailable = isAvailable;
        this.ImageUrl = imageUrl;
        this.lat = lat;
        this.lng = lng;
    }

    public Vehicle(CreateVehicleCommand command){
        this.details = new Details(command.type(), command.name(), command.year(), command.sellingPrice(), command.rentalPrice());
        this.review = new Review(command.review());
        this.isAvailable = command.isAvailable();
        this.ImageUrl = command.imageUrl();
        this.lat = command.lat();
        this.lng = command.lng();
    }

    public Vehicle(){}

    public void updateDetails(String type, String name, Integer year, Double sellingPrice, Integer rentalPrice){
        this.details = new Details(type, name, year, sellingPrice, rentalPrice);
    }

    public void updateReview(Integer review){
        this.review = new Review(review);
    }

    public void updateIsAvailable(Boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public void updateImageUrl(String imageUrl){
        this.ImageUrl = imageUrl;
    }

    public void updateLat(Float lat){
        this.lat = lat;
    }

    public void updateLng(Float lng){
        this.lng = lng;
    }

    public String getDetails(){
        return details.getDetails();
    }

    public Integer getReview(){
        return review.getReview();
    }


}
