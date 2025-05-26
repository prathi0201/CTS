using System;
class Program
{
    static (int, string) GetStudentInfo()
    {
        return (101, "Nancy");
    }
    static void Main()
    {
        var (id, name) = GetStudentInfo();
        Console.WriteLine($"ID: {id}, Name: {name}");
    }
}
