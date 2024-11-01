package upc.edu.ecomovil.api.plan.interfaces.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.ecomovil.api.plan.application.internal.QueryServices.PlanQueryService;
import upc.edu.ecomovil.api.plan.application.internal.commandServices.PlanCommnandService;
import upc.edu.ecomovil.api.plan.domain.model.aggregates.Plan;

import java.util.List;

@RestController
@RequestMapping("/api/plan")
public class PlanController {

    @Autowired
    private PlanCommnandService planCommnandService;

    @Autowired
    private PlanQueryService planQueryService;


    @GetMapping
    public List<Plan> getAllPlans() {
        return planQueryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plan> getPostById(@PathVariable Long id) {
        return planQueryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Plan createPlan(@RequestBody Plan plan) {
        return planCommnandService.createPlan(plan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        planCommnandService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
