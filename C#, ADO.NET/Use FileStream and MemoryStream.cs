using System;
using System.IO;
using System.Text;
class Program
{
    static void Main()
    {
        string filePath = "sample.txt";
        File.WriteAllText(filePath, "Hello FileStream!");
        using (FileStream fs = new FileStream(filePath, FileMode.Open))
        {
            byte[] buffer = new byte[fs.Length];
            fs.Read(buffer, 0, buffer.Length);
            string content = Encoding.UTF8.GetString(buffer);
            Console.WriteLine("File content: " + content);
        }
        using (MemoryStream ms = new MemoryStream())
        {
            byte[] data = Encoding.UTF8.GetBytes("Hello MemoryStream!");
            ms.Write(data, 0, data.Length);
            Console.WriteLine($"Bytes written to MemoryStream: {ms.Length}");
        }
    }
}
