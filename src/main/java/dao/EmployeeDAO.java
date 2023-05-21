package dao;


import model.Employee;

import java.awt.*;
import java.util.List;

public interface EmployeeDAO {
    //Создание сотрудника
    void create(Employee employee);
    //Получение сотрудника по id
    Employee readById(int id);
    //Получение всех объектов в списке
    List<Employee> readAll();
    void updateById(int id,String first_name);
    void deleteById(int id);
}