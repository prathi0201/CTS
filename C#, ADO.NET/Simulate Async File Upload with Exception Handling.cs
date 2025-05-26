using System;
using System.Threading.Tasks;
class Program
{
    static async Task<string> UploadFileAsync()
    {
        await Task.Delay(3000); // Simulate 3 seconds upload
        return "File uploaded successfully!";
    }
    static async Task Main()
    {
        try
        {
            Console.WriteLine("Uploading file...");
            string result = await UploadFileAsync();
            Console.WriteLine(result);
        }
        catch (Exception ex)
        {
            Console.WriteLine("Error during upload: " + ex.Message);
        }
    }
}
