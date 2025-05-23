import java.sql.*;
import java.util.Scanner;
public class BankTransactionSystem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASS = "password";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountDAO accountDAO = new AccountDAO(DB_URL, USER, PASS);
        try {
            System.out.println("Bank Transaction System");
            accountDAO.displayAllAccounts();        
            System.out.print("Enter source account ID: ");
            int fromAccount = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter destination account ID: ");
            int toAccount = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter amount to transfer: ");
            double amount = Double.parseDouble(scanner.nextLine());
            boolean success = accountDAO.transferMoney(fromAccount, toAccount, amount);     
            if (success) {
                System.out.println("Transfer completed successfully!");
            } else {
                System.out.println("Transfer failed. Please check account balances and IDs.");
            }         
            System.out.println("\nUpdated Account Balances:");
            accountDAO.displayAllAccounts();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values.");
        } finally {
            scanner.close();
            accountDAO.closeConnection();
        }
    }
}
class AccountDAO {
    private Connection connection;
    public AccountDAO(String dbUrl, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(dbUrl, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean transferMoney(int fromAccount, int toAccount, double amount) {
        try { 
            connection.setAutoCommit(false);      
            Account source = getAccount(fromAccount);
            if (source == null) {
                System.out.println("Source account not found!");
                return false;
            }
            if (source.getBalance() < amount) {
                System.out.println("Insufficient funds in source account!");
                return false;
            }
            Account destination = getAccount(toAccount);
            if (destination == null) {
                System.out.println("Destination account not found!");
                return false;
            }
            if (!debitAccount(fromAccount, amount)) {
                connection.rollback();
                return false;
            }
            if (!creditAccount(toAccount, amount)) {
                connection.rollback();
                return false;
            }   
            connection.commit();
            return true;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private boolean debitAccount(int accountId, double amount) {
        String sql = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accountId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    private boolean creditAccount(int accountId, double amount) {
        String sql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accountId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    private Account getAccount(int accountId) {
        String sql = "SELECT * FROM accounts WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, accountId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Account(
                    rs.getInt("id"),
                    rs.getString("holder_name"),
                    rs.getDouble("balance")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void displayAllAccounts() {
        String sql = "SELECT * FROM accounts";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {        
            System.out.printf("%-5s %-20s %-15s%n", "ID", "Account Holder", "Balance");
            System.out.println("----------------------------------------");            
            while (rs.next()) {
                System.out.printf("%-5d %-20s $%-15.2f%n",
                    rs.getInt("id"),
                    rs.getString("holder_name"),
                    rs.getDouble("balance"));
            }
            System.out.println();
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
class Account {
    private int id;
    private String holderName;
    private double balance;
    public Account(int id, String holderName, double balance) {
        this.id = id;
        this.holderName = holderName;
        this.balance = balance;
    }
    public int getId() { return id; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
}
