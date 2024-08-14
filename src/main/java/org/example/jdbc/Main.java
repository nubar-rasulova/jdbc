package org.example.jdbc;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        createTable();
        insertStudent("Nubar", "Rasulova", 23);
        findByName("Nubar");
        findAllStudents();
        updateStudentById(33, "Nubar", "Rasulova", 23);
        deleteStudentById(33);
    }


    public static void createTable() {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres"; // PostgreSQL URL'si
        String username = "postgres"; // Veritabanı kullanıcı adı
        String password = "2001"; // Veritabanı şifresi

        String createTableSQL = "CREATE TABLE students (" +
                "id SERIAL PRIMARY KEY, " +  // SERIAL tipi PostgreSQL'de otomatik artırımlı bir tamsayıdır
                "name VARCHAR(50), " +
                "surname VARCHAR(50), " +
                "age INT)";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement()) {

            stmt.execute(createTableSQL);
            System.out.println("Table 'students' is created!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertStudent(String name, String surname, int age) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "2001";

        String insertSQL = "INSERT INTO students (name, surname, age) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setString(1, name);
            pstmt.setString(2, surname);
            pstmt.setInt(3, age);

            pstmt.executeUpdate();
            System.out.println("Student inserted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findByName(String name) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "2001";

        String selectSQL = "SELECT * FROM students WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String studentName = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");

                System.out.println("ID: " + id + ", Name: " + studentName + ", Surname: " + surname + ", Age: " + age);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findAllStudents() {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "2001";

        String selectSQL = "SELECT * FROM students";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(selectSQL);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");

                System.out.println("ID: " + id + ", Name: " + name + ", Surname: " + surname + ", Age: " + age);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateStudentById(int id, String name, String surname, int age) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "2001";

        String updateSQL = "UPDATE students SET name = ?, surname = ?, age = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            pstmt.setString(1, name);
            pstmt.setString(2, surname);
            pstmt.setInt(3, age);
            pstmt.setInt(4, id);

            pstmt.executeUpdate();
            System.out.println("Student updated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteStudentById(int id) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "2001";

        String deleteSQL = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
            System.out.println("Student deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
