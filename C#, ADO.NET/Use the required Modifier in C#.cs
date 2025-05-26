using System;
class Student
{
    public required string Name { get; set; }
    public required int RollNumber { get; set; }
}
class Program
{
    static void Main()
    {
        var student2 = new Student { Name = "Arjun", RollNumber = 101 };
        Console.WriteLine($"Student: {student2.Name}, Roll Number: {student2.RollNumber}");
    }
}
