package service;


import model.Employee;

import java.awt.*;
import java.util.List;

public interface EmployeeDAO {
    //Создание сотрудника
    void create(Employee employee);
    //Получение сотрудника по id
    Employee readById(long id);
    //Получение всех объектов в списке
    List<Employee> readAll();
    void update(Employee employee);
    void delete(Employee employee);
}