using System;
class MyClass
{
    public int Number;
}
class Program
{
    static void ModifyValueType(int x)
    {
        x = 100;
    }
    static void ModifyReferenceType(MyClass obj)
    {
        obj.Number = 100;
    }
    static void Main(string[] args)
    {
        int a = 10;
        Console.WriteLine("Before ModifyValueType: " + a);
        ModifyValueType(a);
        Console.WriteLine("After ModifyValueType: " + a);
        MyClass b = new MyClass();
        b.Number = 10;
        Console.WriteLine("Before ModifyReferenceType: " + b.Number);
        ModifyReferenceType(b);
        Console.WriteLine("After ModifyReferenceType: " + b.Number);
    }
}
