package upc.edu.ecomovil.api.vehicle.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateVehicleCommand {
    private String type;
    private String brand;
    private String model;
    private int year;
    private String features;
}
