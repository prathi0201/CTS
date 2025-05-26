using System;
class Person
{
    public string? Name { get; set; }
    public string? Address { get; set; }
}
class Program
{
    static void Main()
    {
        Person? person = null;
        string name = person?.Name ?? "Unknown";
        Console.WriteLine("Person Name: " + name);
        person = new Person { Name = "John", Address = null };
        string address = person.Address ?? "Address not available";
        Console.WriteLine("Person Address: " + address);
        if (person?.Name != null)
        {
            Console.WriteLine("Length of Name: " + person.Name.Length);
        }
    }
}
