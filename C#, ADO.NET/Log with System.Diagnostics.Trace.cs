using System;
using System.Diagnostics;
using System.IO;
class Logger
{
    public static void SetupLogging()
    {
        TextWriterTraceListener fileListener = new TextWriterTraceListener("log.txt");
        Trace.Listeners.Add(fileListener);
        Trace.Listeners.Add(new ConsoleTraceListener());
    }
    public static void Log(string message)
    {
        Trace.WriteLine($"{DateTime.Now}: {message}");
        Trace.Flush();
    }
}
class Program
{
    static void Main()
    {
        Logger.SetupLogging();
        Logger.Log("Application started.");
        Logger.Log("Performing some task...");
        Logger.Log("Application ended.");
    }
}
