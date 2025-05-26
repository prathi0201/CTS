using System;
using System.Collections.Generic;
class Program
{
    static void Main()
    {
        List<string> names = new List<string> { "Alice", "Bob", "Charlie" };
        names.Add("Diana");
        names.Remove("Bob");
        Console.WriteLine("Names in List:");
        foreach (var name in names)
        {
            Console.WriteLine(name);
        }
        Dictionary<int, string> idMap = new Dictionary<int, string>
        {
            {1, "Apple"},
            {2, "Banana"},
            {3, "Cherry"}
        };
        idMap.Add(4, "Date");
        idMap.Remove(2);
        Console.WriteLine("\nEntries in Dictionary:");
        foreach (var kvp in idMap)
        {
            Console.WriteLine($"Key: {kvp.Key}, Value: {kvp.Value}");
        }
    }
}
