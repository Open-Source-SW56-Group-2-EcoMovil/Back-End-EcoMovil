package upc.edu.ecomovil.api.plan.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import upc.edu.ecomovil.api.plan.domain.model.aggregates.Plan;
import upc.edu.ecomovil.api.shared.domain.model.entities.AuditableModel;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Feature extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private double cost;

    @NotBlank
    private int post;

    @ElementCollection
    private List<String> extras ;

    @OneToOne
    @JoinColumn(name = "plan_id", nullable = false) // la columna que mapea la relación
    private Plan plan;

//    public Feature(CreateGreenLeafCommand command) {
//        this.title = command.title();
//        this.scenario = command.scenario();
//        this.tip = command.tip();
//        this.bigTree = new BigTree();
//    }

}
