package com.example.hwdatabase;

import dao.EmployeeDAO;
import model.Employee;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.EmployeeDaoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HwDataBaseApplication {

    public static void main(String[] args) {
        final String user = "postgres";
        final String password = "2550";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT first_name, last_name, gender, age, city_name \n" +
                     "FROM city\n" +
                     "INNER JOIN employee\n" +
                     "ON city.city_id=employee.city_id AND employee.id = 5;")
        ){
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String first_name = "first_name: " + resultSet.getString("first_name");
                String gender = "gender: " + resultSet.getString("gender");
                String last_name = "last_name: " + resultSet.getString("last_name");
                String age = "age: " + resultSet.getInt("age");
                String city_name = "city_name: " + resultSet.getString("city_name");
                System.out.println(first_name);
                System.out.println(last_name);
                System.out.println(gender);
                System.out.println(age);
                System.out.println(city_name);
                System.out.println();


                EmployeeDAO employeeDAO = new EmployeeDaoImpl(connection);

                Employee employee = new Employee("Leonid", "Shevchenko", "Man",55,3);

                // Вызываем метод добавления объекта
                employeeDAO.create(employee);

                // Создаем список наполняя его объектами, которые получаем
                // путем вызова метода для получения всех элементов таблицы
                List<Employee> list = new ArrayList<>(employeeDAO.readAll());

                // Выведем список в консоль
                for (Employee employee1 : list) {
                    System.out.println(employee1);
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}