using System;
class Program
{
    static void Main()
    {
        int x = 5;
        Console.WriteLine("Before ref method: " + x);
        ModifyRef(ref x);
        Console.WriteLine("After ref method: " + x);
        int y;
        ProvideOut(out y);
        Console.WriteLine("Value from out method: " + y);
        int z = 50;
        UseIn(in z);
    }
    static void ModifyRef(ref int value)
    {
        value += 10;
    }
    static void ProvideOut(out int value)
    {
        value = 100;
    }
    static void UseIn(in int value)
    {
        Console.WriteLine("Read-only value from in method: " + value);
    }
}
