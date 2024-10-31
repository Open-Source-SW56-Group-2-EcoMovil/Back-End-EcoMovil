package upc.edu.ecomovil.api.user.application.internal.queryservices;

import org.springframework.stereotype.Service;
import upc.edu.ecomovil.api.user.domain.model.entities.Student;
import upc.edu.ecomovil.api.user.domain.model.queries.Student.GetAllStudentQuery;
import upc.edu.ecomovil.api.user.domain.services.StudentQueryService;
import upc.edu.ecomovil.api.user.infrastructure.persistence.jpa.repositories.StudentRepository;

import java.util.List;

@Service
public class StudentQueryServiceImpl implements StudentQueryService {
    private final StudentRepository studentRepository;

    public StudentQueryServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> handle(GetAllStudentQuery query) {
        return studentRepository.findAll();
    }

    //@Override
    //public List<Student> handle(GetAllStudentsByPlanIdQuery query) {
    //    return studentRepository.findByPlanId(query.planId());
    //}
}
