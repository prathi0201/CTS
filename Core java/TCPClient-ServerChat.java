import java.io.*;
import java.net.*;
import java.util.Scanner;
public class ChatServer {
    public static void main(String[] args) {
        int port = 12345; // You can choose any available port
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        Scanner consoleInput = new Scanner(System.in);
        try {   
            serverSocket = new ServerSocket(port);
            System.out.println("Server started. Listening on port " + port);     
            clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());          .
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true); // true for auto-flush
            String clientMessage;
            String serverMessage;
            while (true) {
         
                clientMessage = in.readLine();
                if (clientMessage == null || clientMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected or sent 'exit'.");
                    break;
                }
                System.out.println("Client: " + clientMessage);              
                System.out.print("Server: ");
                serverMessage = consoleInput.nextLine();
                out.println(serverMessage); // Send to client
                if (serverMessage.equalsIgnoreCase("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (consoleInput != null) consoleInput.close();
                if (out != null) out.close();
                if (in != null) in.close();
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class ChatClient {
    public static void main(String[] args) {
        String hostname = "localhost"; // Server's IP address or hostname
        int port = 12345; // Must match the server's port
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        Scanner consoleInput = new Scanner(System.in);
        try {
            socket = new Socket(hostname, port);
            System.out.println("Connected to server on " + hostname + ":" + port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true); // true for auto-flush
            String clientMessage;
            String serverMessage;
            while (true) {              
                System.out.print("Client: ");
                clientMessage = consoleInput.nextLine();
                out.println(clientMessage); // Send to server
                if (clientMessage.equalsIgnoreCase("exit")) {
                    break;
                }     
                serverMessage = in.readLine();
                if (serverMessage == null || serverMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Server disconnected or sent 'exit'.");
                    break;
                }
                System.out.println("Server: " + serverMessage);
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + hostname);
        } catch (IOException e) {
            System.err.println("Error: Could not connect to server or I/O error: " + e.getMessage());
        } finally {
            try {
                if (consoleInput != null) consoleInput.close();
                if (out != null) out.close();
                if (in != null) in.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
