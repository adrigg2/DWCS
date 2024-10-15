package com.adrian;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
    private String url;
    private String user;
    private String password;

    public DAO(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }
    
    public boolean admission(int id, String name, float salary) {
        String sql = "INSERT INTO EMPLOYEES(id, name, salary) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement sentence = connection.prepareStatement(sql)) {
            sentence.setInt(1, id);
            sentence.setString(2, name);
            sentence.setFloat(3, salary);

            int rows = sentence.executeUpdate();

            return rows > 0;
        } catch (SQLException e) {
            System.out.println("There has been an error when establishing a connection with the database: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM EMPLOYEES WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement sentence = connection.prepareStatement(sql)) {
            sentence.setInt(1, id);

            int rows = sentence.executeUpdate();

            return rows > 0;
        } catch (SQLException e) {
            System.out.println("There has been an error when establishing a connection with the database: " + e.getMessage());
            return false;
        }
    }

    public boolean modify(int id, String name, float salary) {
        String sql = "UPDATE EMPLOYEES SET name = ?, salary = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement sentence = connection.prepareStatement(sql)) {
            sentence.setString(1, name);
            sentence.setFloat(2, salary);
            sentence.setInt(3, id);

            int rows = sentence.executeUpdate();

            return rows > 0;
        } catch (SQLException e) {
            System.out.println("There has been an error when establishing a connection with the database: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Employee> checkData(float minSalary, float maxSalary) {
        String sql = "SELECT * FROM EMPLOYEES WHERE salary > ? and salary < ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement sentence = connection.prepareStatement(sql)) {
            sentence.setFloat(1, minSalary);
            sentence.setFloat(2, maxSalary);

            try (ResultSet result = sentence.executeQuery()) {
                ArrayList<Employee> employees = new ArrayList<>();
                while (result.next()) {
                    Employee employee = new Employee(result.getString("name"), result.getInt("id"), result.getFloat("salary"));
                    employees.add(employee);
                }
                return employees
            }

            return rows > 0;
        } catch (SQLException e) {
            System.out.println("There has been an error when establishing a connection with the database: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
