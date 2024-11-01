package upc.edu.ecomovil.api.plan.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import upc.edu.ecomovil.api.plan.domain.model.entities.Feature;
import upc.edu.ecomovil.api.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Plan extends AuditableAbstractAggregateRoot<Plan> {

    @NotBlank
    @Column(unique = true)
    private String name;

    @OneToOne(mappedBy = "plan", cascade = CascadeType.ALL)
    Feature feature;

//    public Plan(CreateProfileCommand command) {
//        this.name = new PersonName(command.firstName(), command.lastName());
//        this.email = new EmailAddress(command.email());
//        this.address = new StreetAddress(command.street(), command.number(), command.city(), command.postalCode(), command.country());
//    }
}
