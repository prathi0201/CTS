using System;
class Program
{
    static void Main()
    {
        Console.WriteLine("Sum of 10 and 20: " + CalculateTotal(10, 20));
        Console.WriteLine("Sum of 1.1, 2.2, and 3.3: " + CalculateTotal(1.1, 2.2, 3.3));
    }
    static int CalculateTotal(int a, int b)
    {
        return a + b;
    }
    static double CalculateTotal(double a, double b, double c)
    {
        return a + b + c;
    }
}
