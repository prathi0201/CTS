using System;
using System.Data;
using System.Data.SqlClient;
class Program
{
    static string connectionString = "Server=localhost;Database=YourDB;Trusted_Connection=True;";
    static void InsertEmployee()
    {
        using SqlConnection conn = new SqlConnection(connectionString);
        conn.Open();
        string query = "INSERT INTO Employees (Name, Age) VALUES (@name, @age)";
        SqlCommand cmd = new SqlCommand(query, conn);
        cmd.Parameters.AddWithValue("@name", "Ravi");
        cmd.Parameters.AddWithValue("@age", 28);
        cmd.ExecuteNonQuery();
    }
    static void ReadEmployees()
    {
        using SqlConnection conn = new SqlConnection(connectionString);
        conn.Open();
        string query = "SELECT * FROM Employees";
        SqlCommand cmd = new SqlCommand(query, conn);
        SqlDataReader reader = cmd.ExecuteReader();
        while (reader.Read())
        {
            Console.WriteLine($"ID: {reader["Id"]}, Name: {reader["Name"]}, Age: {reader["Age"]}");
        }
    }
    static void UpdateEmployee()
    {
        using SqlConnection conn = new SqlConnection(connectionString);
        conn.Open();
        string query = "UPDATE Employees SET Age = @age WHERE Name = @name";
        SqlCommand cmd = new SqlCommand(query, conn);
        cmd.Parameters.AddWithValue("@age", 30);
        cmd.Parameters.AddWithValue("@name", "Ravi");
        cmd.ExecuteNonQuery();
    }
    static void DeleteEmployee()
    {
        using SqlConnection conn = new SqlConnection(connectionString);
        conn.Open();
        string query = "DELETE FROM Employees WHERE Name = @name";
        SqlCommand cmd = new SqlCommand(query, conn);
        cmd.Parameters.AddWithValue("@name", "Ravi");
        cmd.ExecuteNonQuery();
    }
    static void Main()
    {
        InsertEmployee();
        ReadEmployees();
        UpdateEmployee();
        ReadEmployees();
        DeleteEmployee();
        ReadEmployees();
    }
}
