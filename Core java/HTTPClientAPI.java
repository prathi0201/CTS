import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject; // For a generic JSON object
import com.google.gson.JsonSyntaxException; // For handling JSON parsing errors
public class HttpClientApiDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- HTTP Client API Demo (Java 11+) ---");
        System.out.print("Enter the API URL (e.g., https://api.github.com/users/octocat): ");
        String apiUrl = scanner.nextLine();
        if (apiUrl.trim().isEmpty()) {
            System.err.println("API URL cannot be empty. Exiting.");
            scanner.close();
            return;
        }  
        HttpClient httpClient = HttpClient.newHttpClient();       
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET() 
                .build();
        try {         
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());    
            System.out.println("\n--- HTTP Response ---");
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Headers: " + response.headers().map()); // Print all headers
            System.out.println("Response Body:\n" + response.body());
            if (response.statusCode() == 200 && response.body().trim().startsWith("{")) { 
                try {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
                    System.out.println("\n--- Parsed JSON (using Gson) ---");
                    System.out.println(gson.toJson(jsonObject)); // Print prettified JSON             
                    if (jsonObject.has("name") && jsonObject.get("name").isJsonPrimitive()) {
                        System.out.println("\nExtracted 'name': " + jsonObject.get("name").getAsString());
                    }
                    if (jsonObject.has("login") && jsonObject.get("login").isJsonPrimitive()) {
                        System.out.println("Extracted 'login': " + jsonObject.get("login").getAsString());
                    }
                } catch (JsonSyntaxException e) {
                    System.err.println("\nError parsing JSON: " + e.getMessage());
                }
            } else {
                System.out.println("\n(Skipping JSON parsing as response is not successful or doesn't look like JSON)");
            }
        } catch (IOException e) {
            System.err.println("I/O error during HTTP request: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("HTTP request was interrupted: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore the interrupted status
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid URL: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
