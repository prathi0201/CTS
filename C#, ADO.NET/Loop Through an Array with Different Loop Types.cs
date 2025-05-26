using System;
class Program
{
    static void Main()
    {
        int[] numbers = { 5, 10, 15, 20, 25 };
        Console.WriteLine("For loop:");
        for (int i = 0; i < numbers.Length; i++)
        {
            if (numbers[i] == 15) continue;
            Console.WriteLine(numbers[i]);
        }
        Console.WriteLine("\nForeach loop:");
        foreach (int number in numbers)
        {
            if (number == 20) break;
            Console.WriteLine(number);
        }
        Console.WriteLine("\nWhile loop:");
        int j = 0;
        while (j < numbers.Length)
        {
            if (numbers[j] == 10)
            {
                j++;
                continue;
            }
            Console.WriteLine(numbers[j]);
            j++;
        }
        Console.WriteLine("\nDo-While loop:");
        int k = 0;
        do
        {
            if (numbers[k] == 25) break;
            Console.WriteLine(numbers[k]);
            k++;
        } while (k < numbers.Length);
    }
}
