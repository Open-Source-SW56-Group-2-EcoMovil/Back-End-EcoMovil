package upc.edu.ecomovil.api.plan.domain.model.valueObjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Date(int month, int year) {
    public Date() { this(0, 0); }
}