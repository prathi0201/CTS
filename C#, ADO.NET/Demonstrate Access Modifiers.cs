using System;
class BaseClass
{
    public string publicField = "Public Field";
    private string privateField = "Private Field";
    protected string protectedField = "Protected Field";
    public void ShowPrivateField()
    {
        Console.WriteLine("Accessing privateField inside BaseClass: " + privateField);
    }
}
class DerivedClass : BaseClass
{
    public void ShowFields()
    {
        Console.WriteLine(publicField);
        Console.WriteLine(protectedField);
    }
}
class NonDerivedClass
{
    public void ShowFields()
    {
        BaseClass obj = new BaseClass();
        Console.WriteLine(obj.publicField);
    }
}
class Program
{
    static void Main()
    {
        DerivedClass derived = new DerivedClass();
        Console.WriteLine("From Derived Class:");
        derived.ShowFields();
        NonDerivedClass nonDerived = new NonDerivedClass();
        Console.WriteLine("\nFrom Non-Derived Class:");
        nonDerived.ShowFields();
    }
}
