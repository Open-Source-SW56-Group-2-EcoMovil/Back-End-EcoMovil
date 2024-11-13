package upc.edu.ecomovil.api.vehicles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Prices(Double Price) {
    public Prices() { this(null); }

    public Prices {
        if (Price == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }
    }

    public Double getPrice() {
        return Price;
    }
}
