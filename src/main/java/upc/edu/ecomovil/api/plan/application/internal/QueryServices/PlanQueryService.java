package upc.edu.ecomovil.api.plan.application.internal.QueryServices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.ecomovil.api.plan.domain.model.aggregates.Plan;
import upc.edu.ecomovil.api.plan.infraestructure.persistence.jpa.repositories.PlanRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlanQueryService {
    @Autowired
    private PlanRepository planRepository;

    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    public Optional<Plan> findById(Long id) {
        return planRepository.findById(id);
    }

    public Plan save(Plan plan) {
        return planRepository.save(plan);
    }


}
