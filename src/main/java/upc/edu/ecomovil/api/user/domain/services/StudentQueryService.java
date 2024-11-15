package upc.edu.ecomovil.api.user.domain.services;

import upc.edu.ecomovil.api.user.domain.model.entities.Student;
import upc.edu.ecomovil.api.user.domain.model.queries.Student.GetAllStudentByPlanIdQuery;
import upc.edu.ecomovil.api.user.domain.model.queries.Student.GetAllStudentQuery;

import java.util.List;

public interface StudentQueryService {
    List<Student> handle(GetAllStudentQuery query);
    List<Student> handle(GetAllStudentByPlanIdQuery query);
//    List<Student> handle(GetAllStudentsByPlanIdQuery query);
}
