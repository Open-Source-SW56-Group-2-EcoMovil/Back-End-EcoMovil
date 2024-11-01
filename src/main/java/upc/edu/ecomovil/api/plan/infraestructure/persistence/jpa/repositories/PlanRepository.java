package upc.edu.ecomovil.api.plan.infraestructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.ecomovil.api.plan.domain.model.aggregates.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

}
