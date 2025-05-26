using System;
class Program
{
    static void DescribeObject(object obj)
    {
        if (obj is int number)
        {
            Console.WriteLine($"It's an integer: {number}");
        }
        else if (obj is string text)
        {
            Console.WriteLine($"It's a string: \"{text}\"");
        }
        else if (obj is null)
        {
            Console.WriteLine("It's null.");
        }
        else
        {
            Console.WriteLine("Unknown type.");
        }
        switch (obj)
        {
            case int i when i > 0:
                Console.WriteLine("Positive integer");
                break;
            case int i:
                Console.WriteLine("Non-positive integer");
                break;
            case string s when s.Length > 5:
                Console.WriteLine("Long string");
                break;
            case string s:
                Console.WriteLine("Short string");
                break;
            case null:
                Console.WriteLine("Null object in switch.");
                break;
            default:
                Console.WriteLine("Something else.");
                break;
        }
    }
    static void Main()
    {
        DescribeObject(42);
        Console.WriteLine();
        DescribeObject("Hello");
        Console.WriteLine();
        DescribeObject(null);
        Console.WriteLine();
        DescribeObject(0.5);
    }
}
