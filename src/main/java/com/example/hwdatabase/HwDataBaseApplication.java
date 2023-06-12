package com.example.hwdatabase;

import model.City;
import service.CrudDaoImpl;
import model.Employee;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class HwDataBaseApplication {

    public static void main(String[] args) {
        CrudDaoImpl crudDao = new CrudDaoImpl();
        City city = new City("Зарядье");
        Employee employee = new Employee("Петр", "Иванов","Мужской",27 ,city);
        crudDao.create(employee);
    }
}