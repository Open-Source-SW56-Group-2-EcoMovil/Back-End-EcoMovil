package upc.edu.ecomovil.api.plan.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import upc.edu.ecomovil.api.plan.domain.model.aggregates.Checkout;
import upc.edu.ecomovil.api.plan.domain.model.valueObjects.Date;
import upc.edu.ecomovil.api.shared.domain.model.entities.AuditableModel;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Card extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String number;

    @NotBlank
    Date expiryDate;

    @NotBlank
    private int scc;

    @ElementCollection
    private List<String> extras ;

    @OneToOne
    @JoinColumn(name = "checkout_id") // esto es opcional, solo si quieres especificar el nombre de la columna
    private Checkout checkout;

//    public Card(CreateGreenLeafCommand command) {
//        this.title = command.title();
//        this.scenario = command.scenario();
//        this.tip = command.tip();
//        this.bigTree = new BigTree();
//    }

}
