using System;
class Shape
{
    public virtual void Draw()
    {
        Console.WriteLine("Drawing a shape.");
    }
}
class Circle : Shape
{
    public override void Draw()
    {
        Console.WriteLine("Drawing a circle.");
    }
}
class Rectangle : Shape
{
    public override void Draw()
    {
        Console.WriteLine("Drawing a rectangle.");
    }
}
class Program
{
    static void Main()
    {
        Shape shape1 = new Circle();
        Shape shape2 = new Rectangle();
        shape1.Draw();
        shape2.Draw();
    }
}
