using System;
class MyClass
{
    public int Id { get; set; } = 1;
}
class Program
{
    static void Main()
    {
        var number = 10; 
        var text = "Hello"; 
        var obj = new MyClass();
        MyClass another = new();
        Console.WriteLine($"number (type: {number.GetType()}): {number}");
        Console.WriteLine($"text (type: {text.GetType()}): {text}");
        Console.WriteLine($"obj (type: {obj.GetType()}): Id = {obj.Id}");
        Console.WriteLine($"another (type: {another.GetType()}): Id = {another.Id}");
    }
}
