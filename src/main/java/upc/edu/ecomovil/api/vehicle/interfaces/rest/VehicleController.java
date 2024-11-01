package upc.edu.ecomovil.api.vehicle.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.ecomovil.api.vehicle.application.internal.commandservices.VehicleCommandService;
import upc.edu.ecomovil.api.vehicle.application.internal.queryservices.VehicleQueryService;
import upc.edu.ecomovil.api.vehicle.domain.model.commands.CreateVehicleCommand;
import upc.edu.ecomovil.api.vehicle.domain.model.entities.Vehicle;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleCommandService vehicleCommandService;

    @Autowired
    private VehicleQueryService vehicleQueryService;

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody CreateVehicleCommand command) {
        Vehicle vehicle = vehicleCommandService.createVehicle(command);
        return new ResponseEntity<>(vehicle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody CreateVehicleCommand command) {
        Vehicle updatedVehicle = vehicleCommandService.updateVehicle(id, command);
        return ResponseEntity.ok(updatedVehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleCommandService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Vehicle vehicle = vehicleQueryService.getVehicleById(id);
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping("/type")
    public ResponseEntity<List<Vehicle>> getVehiclesByType(@RequestParam String type) {
        List<Vehicle> vehicles = vehicleQueryService.getVehiclesByType(type);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleQueryService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }
}
