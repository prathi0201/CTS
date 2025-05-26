using System;
abstract class Vehicle
{
    public abstract void Drive();
}

interface IDrivable
{
    void Start();
}
class Car : Vehicle, IDrivable
{
    public override void Drive()
    {
        Console.WriteLine("Car is driving.");
    }
    public void Start()
    {
        Console.WriteLine("Car has started.");
    }
}
class Program
{
    static void Main()
    {
        Vehicle myVehicle = new Car();
        myVehicle.Drive();
        IDrivable myDrivable = new Car();
        myDrivable.Start();
    }
}
