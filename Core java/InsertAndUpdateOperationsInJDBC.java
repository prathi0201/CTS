import java.sql.*;
import java.util.Scanner;
public class StudentManagementSystem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER = "root";
    private static final String PASS = "password";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO(DB_URL, USER, PASS);
        try {
            System.out.println("Student Management System");
            System.out.println("1. Add new student");
            System.out.println("2. Update student details");
            System.out.println("3. View all students");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = Integer.parseInt(scanner.nextLine());  
                    Student newStudent = new Student(name, email, age);
                    int rowsInserted = studentDAO.insertStudent(newStudent);
                    System.out.println(rowsInserted + " student(s) added successfully!");
                    break;                    
                case 2:
                    System.out.print("Enter student ID to update: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new name (leave blank to keep current): ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new email (leave blank to keep current): ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter new age (enter 0 to keep current): ");
                    int newAge = Integer.parseInt(scanner.nextLine());                    
                    int rowsUpdated = studentDAO.updateStudent(id, newName, newEmail, newAge);
                    System.out.println(rowsUpdated + " student(s) updated successfully!");
                    break;                   
                case 3:
                    studentDAO.displayAllStudents();
                    break;                    
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numbers for age and ID fields");
        } finally {
            scanner.close();
            studentDAO.closeConnection();
        }
    }
}
class StudentDAO {
    private Connection connection;
    public StudentDAO(String dbUrl, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(dbUrl, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public int insertStudent(Student student) {
        String sql = "INSERT INTO students (name, email, age) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setInt(3, student.getAge());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int updateStudent(int id, String newName, String newEmail, int newAge) {   
        Student current = getStudentById(id);
        if (current == null) {
            System.out.println("Student with ID " + id + " not found!");
            return 0;
        }
        String sql = "UPDATE students SET name = ?, email = ?, age = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, newName.isEmpty() ? current.getName() : newName);
            pstmt.setString(2, newEmail.isEmpty() ? current.getEmail() : newEmail);
            pstmt.setInt(3, newAge == 0 ? current.getAge() : newAge);
            pstmt.setInt(4, id);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    private Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getInt("age")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void displayAllStudents() {
        String sql = "SELECT * FROM students";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.printf("%-5s %-20s %-25s %-5s%n", "ID", "Name", "Email", "Age");
            System.out.println("------------------------------------------------------");            
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-25s %-5d%n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
class Student {
    private int id;
    private String name;
    private String email;
    private int age;
    public Student(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public Student(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
}
