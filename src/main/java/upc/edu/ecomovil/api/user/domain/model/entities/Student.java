package upc.edu.ecomovil.api.user.domain.model.entities;

import jakarta.persistence.*;
import upc.edu.ecomovil.api.user.domain.model.aggregates.Profile;
import upc.edu.ecomovil.api.user.domain.model.commands.CreateStudentCommand;
import upc.edu.ecomovil.api.user.domain.model.valueobjects.RucNumber;

@Entity
public class Student extends Profile {
    //falta relaciones con vehicles y plans

    @Embedded
    private RucNumber ruc;

    public Student(String firstName, String lastName, String email, String phoneNumber, String ruc) {
        super(firstName, lastName, email, phoneNumber);
        this.ruc = new RucNumber(ruc);
    }

    public Student() {
        super();
    }

    public Student(CreateStudentCommand command) {
        super(command.firstName(), command.lastName(), command.email(), command.phoneNumber());
        this.ruc = new RucNumber(command.rucNumber());
    }

    public void updateRuc(String ruc){
        this.ruc = new RucNumber(ruc);
    }

    public String getRuc(){
        return ruc.getRucNumber();
    }
}
