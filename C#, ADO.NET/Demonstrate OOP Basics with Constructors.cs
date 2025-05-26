using System;
class Car
{
    public string Make;
    public string Model;
    public int Year;
    public Car()
    {
        Make = "Unknown";
        Model = "Unknown";
        Year = 0;
    }
    public Car(string make, string model, int year)
    {
        Make = make;
        Model = model;
        Year = year;
    }
    public void DisplayInfo()
    {
        Console.WriteLine($"Make: {Make}, Model: {Model}, Year: {Year}");
    }
}
class Program
{
    static void Main()
    {
        Car car1 = new Car();
        Car car2 = new Car("Toyota", "Corolla", 2020);
        Console.WriteLine("Car 1 (Default Constructor):");
        car1.DisplayInfo();
        Console.WriteLine("\nCar 2 (Parameterized Constructor):");
        car2.DisplayInfo();
    }
}
