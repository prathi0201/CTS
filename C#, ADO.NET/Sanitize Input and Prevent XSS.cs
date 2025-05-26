using System;
using System.Net;
class Program
{
    static void Main()
    {
        Console.Write("Enter your comment: ");
        string input = Console.ReadLine();
        string sanitizedInput = WebUtility.HtmlEncode(input);
        Console.WriteLine("Sanitized Output: " + sanitizedInput);
    }
}
