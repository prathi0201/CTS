using System;
class Contact
{
    public string? Name { get; set; }
    public string? PhoneNumber { get; set; }
}
class Program
{
    static void Main()
    {
        Contact? contact1 = null;
        Contact? contact2 = new Contact { Name = null, PhoneNumber = "1234567890" };
        Contact? contact3 = new Contact { Name = "Emily", PhoneNumber = "9876543210" };
        Console.WriteLine("Contact 1 Name: " + (contact1?.Name ?? "No contact"));
        Console.WriteLine("Contact 2 Name: " + (contact2?.Name ?? "No name"));
        Console.WriteLine("Contact 3 Name: " + (contact3?.Name ?? "No name"));
    }
}
