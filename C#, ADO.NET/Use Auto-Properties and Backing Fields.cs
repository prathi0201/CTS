using System;
class Product
{
    public string Name { get; set; }
    private double _price;
    public double Price
    {
        get { return _price; }
        set
        {
            if (value < 0)
            {
                Console.WriteLine("Invalid Price! Setting price to 0.");
                _price = 0;
            }
            else
            {
                _price = value;
            }
        }
    }
}
class Program
{
    static void Main()
    {
        Product product1 = new Product();
        product1.Name = "Laptop";
        product1.Price = -1200; 
        Console.WriteLine($"Product: {product1.Name}, Price: {product1.Price}");
        Product product2 = new Product
        {
            Name = "Phone",
            Price = 699
        };
        Console.WriteLine($"Product: {product2.Name}, Price: {product2.Price}");
    }
}
