import java.sql.*;
import java.util.Scanner;
public class JdbcExample {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER = "root";
    private static final String PASS = "password";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  
        System.out.println("JDBC Connection Example");
        System.out.print("Enter table name to query (e.g., students): ");
        String tableName = scanner.nextLine();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database...");
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
                System.out.println("Connected successfully!");
                String sql = "SELECT * FROM " + tableName;
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(sql)) {
                    ResultSetMetaData metaData = rs.getMetaData();
                    int columnCount = metaData.getColumnCount();  
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf("%-20s", metaData.getColumnName(i));
                    }
                    System.out.println();
                    while (rs.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.printf("%-20s", rs.getString(i));
                        }
                        System.out.println();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed or SQL error!");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
