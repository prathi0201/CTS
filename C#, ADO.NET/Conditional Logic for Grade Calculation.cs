using System;
class Program
{
    static void Main()
    {
        Console.Write("Enter your score (0-100): ");
        int score = int.Parse(Console.ReadLine());
        if (score >= 90)
            Console.WriteLine("Grade: A");
        else if (score >= 80)
            Console.WriteLine("Grade: B");
        else if (score >= 70)
            Console.WriteLine("Grade: C");
        else if (score >= 60)
            Console.WriteLine("Grade: D");
        else
            Console.WriteLine("Grade: F");
        switch (score)
        {
            case int s when s >= 90:
                Console.WriteLine("Switch Grade: A");
                break;
            case int s when s >= 80:
                Console.WriteLine("Switch Grade: B");
                break;
            case int s when s >= 70:
                Console.WriteLine("Switch Grade: C");
                break;
            case int s when s >= 60:
                Console.WriteLine("Switch Grade: D");
                break;
            default:
                Console.WriteLine("Switch Grade: F");
                break;
        }
    }
}
