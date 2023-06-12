package controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CrudDao;

@RestController
@RequestMapping("/employee")
@Tag(name = "Сотрудники", description = "CRUD операции и другие эндпоинты с сотрудниками")
public class EmployeesController {
    private final CrudDao crudDao;

    public EmployeesController(CrudDao crudDao) {
        this.crudDao = crudDao;
    }

    @PostMapping
    @Operation(
            summary = "Добавление сотрудника"
    )
    public ResponseEntity addEmployee(@RequestBody Employee employee){
        crudDao.create(employee);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Получение сотрудника"
    )
    public ResponseEntity getEmployee(@PathVariable long id){
        crudDao.readById(id,Employee.class);
        return ResponseEntity.ok(crudDao.readById(id,Employee.class));
    }


    @PutMapping("{id}")
    @Operation(
            summary = "Редактирование данных по сотруднику"
    )
    public ResponseEntity editEmployee(@RequestBody Employee employee){
        crudDao.update(employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Удаление сотрудника"
    )
    public ResponseEntity deleteEmployee(@PathVariable Employee employee){
        crudDao.delete(employee);
        return ResponseEntity.ok(employee);
    }
}
