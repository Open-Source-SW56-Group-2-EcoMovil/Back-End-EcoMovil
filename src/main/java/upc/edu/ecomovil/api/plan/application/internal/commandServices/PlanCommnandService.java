package upc.edu.ecomovil.api.plan.application.internal.commandServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.ecomovil.api.plan.domain.model.aggregates.Plan;
import upc.edu.ecomovil.api.plan.infraestructure.persistence.jpa.repositories.PlanRepository;

@Service
public class PlanCommnandService {
    @Autowired
    private PlanRepository planRepository;

    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }

    public void delete(Long id) {
        planRepository.deleteById(id);
    }

}