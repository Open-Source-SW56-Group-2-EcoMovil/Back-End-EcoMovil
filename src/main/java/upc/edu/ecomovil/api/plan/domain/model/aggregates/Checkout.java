package upc.edu.ecomovil.api.plan.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import upc.edu.ecomovil.api.plan.domain.model.entities.Card;
import upc.edu.ecomovil.api.shared.domain.model.entities.AuditableModel;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Checkout extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String userName;

    @OneToOne(mappedBy = "checkout", cascade = CascadeType.ALL)
    Card card;
}
