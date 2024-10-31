package upc.edu.ecomovil.api.user.application.internal.commandservices;

import org.springframework.stereotype.Service;
import upc.edu.ecomovil.api.user.domain.model.commands.CreateStudentCommand;
import upc.edu.ecomovil.api.user.domain.model.entities.Student;
import upc.edu.ecomovil.api.user.domain.model.valueobjects.RucNumber;
import upc.edu.ecomovil.api.user.domain.services.StudentCommandService;
import upc.edu.ecomovil.api.user.infrastructure.persistence.jpa.repositories.StudentRepository;

import java.util.Optional;

@Service
public class StudentCommandServiceImpl implements StudentCommandService {
    private final StudentRepository studentRepository;

    public StudentCommandServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> handle(CreateStudentCommand command){
        var ruc = new RucNumber(command.rucNumber());
        studentRepository.findByRuc(ruc).ifPresent(
                student -> {
                    throw new IllegalArgumentException("Student with RUC " + command.rucNumber() + " already exists");
                });
        var student = new Student(command);
        studentRepository.save(student);
        return Optional.of(student);


    }

}
