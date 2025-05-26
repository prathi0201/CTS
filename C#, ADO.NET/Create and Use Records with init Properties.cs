using System;
public record Employee
{
    public string Name { get; init; }
    public int ID { get; init; }
    public string Department { get; init; }
}
class Program
{
    static void Main()
    {
        var emp1 = new Employee { Name = "Alice", ID = 101, Department = "HR" };
        var emp2 = emp1 with { Department = "Finance" };
        Console.WriteLine("Original Employee:");
        Console.WriteLine(emp1);
        Console.WriteLine("\nModified Copy:");
        Console.WriteLine(emp2);
    }
}
