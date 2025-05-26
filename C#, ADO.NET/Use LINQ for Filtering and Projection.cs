using System;
using System.Collections.Generic;
using System.Linq;
class Order
{
    public int OrderId { get; set; }
    public string CustomerName { get; set; }
    public double TotalAmount { get; set; }
}
class Program
{
    static void Main()
    {
        List<Order> orders = new List<Order>
        {
            new Order { OrderId = 1, CustomerName = "John", TotalAmount = 150 },
            new Order { OrderId = 2, CustomerName = "Sara", TotalAmount = 80 },
            new Order { OrderId = 3, CustomerName = "Mike", TotalAmount = 220 },
            new Order { OrderId = 4, CustomerName = "Tina", TotalAmount = 90 }
        };
        var highValueOrders = from order in orders
                              where order.TotalAmount > 100
                              select new { order.OrderId, order.CustomerName };

        Console.WriteLine("High Value Orders (TotalAmount > 100):");
        foreach (var order in highValueOrders)
        {
            Console.WriteLine($"Order ID: {order.OrderId}, Customer: {order.CustomerName}");
        }
    }
}
