package controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.EmployeeDAO;

@RestController
@RequestMapping("/employee")
@Tag(name = "Сотрудники", description = "CRUD операции и другие эндпоинты с сотрудниками")
public class EmployeesController {
    private final EmployeeDAO employeeDAO;

    public EmployeesController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @PostMapping
    @Operation(
            summary = "Добавление сотрудника"
    )
    public ResponseEntity addEmployee(@RequestBody Employee employee){
        employeeDAO.create(employee);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Получение сотрудника"
    )
    public ResponseEntity getEmployee(@PathVariable long id){
        employeeDAO.readById(id);
        return ResponseEntity.ok(employeeDAO.readById(id));
    }


    @PutMapping("{id}")
    @Operation(
            summary = "Редактирование данных по сотруднику"
    )
    public ResponseEntity editEmployee(@RequestBody Employee employee){
        employeeDAO.update(employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Удаление сотрудника"
    )
    public ResponseEntity deleteEmployee(@PathVariable Employee employee){
        employeeDAO.delete(employee);
        return ResponseEntity.ok(employee);
    }
}
