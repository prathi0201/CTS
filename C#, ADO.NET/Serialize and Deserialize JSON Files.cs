using System;
using System.IO;
using System.Text.Json;
class User
{
    public string Name { get; set; }
    public int Age { get; set; }
    public string Email { get; set; }
}
class Program
{
    static void Main()
    {
        var user = new User { Name = "Asha", Age = 25, Email = "asha@example.com" };
        string filePath = "user.json";
        string jsonString = JsonSerializer.Serialize(user);
        File.WriteAllText(filePath, jsonString);
        string readJson = File.ReadAllText(filePath);
        var deserializedUser = JsonSerializer.Deserialize<User>(readJson);
        Console.WriteLine($"Name: {deserializedUser.Name}, Age: {deserializedUser.Age}, Email: {deserializedUser.Email}");
    }
}
