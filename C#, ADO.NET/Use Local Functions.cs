using System;
class Program
{
    static void Main()
    {
        Console.Write("Enter a number to find factorial: ");
        int number = int.Parse(Console.ReadLine());
        long result = CalculateFactorial(number);
        Console.WriteLine($"Factorial of {number} is {result}");
    }
    static long CalculateFactorial(int n)
    {
        long Factorial(int num)
        {
            if (num <= 1) return 1;
            return num * Factorial(num - 1);
        }
        return Factorial(n);
    }
}
