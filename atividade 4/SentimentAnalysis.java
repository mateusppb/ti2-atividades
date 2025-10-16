import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SentimentAnalysis {
    public static void main(String[] args) throws Exception {

        String endpoint = "https://mateusia.cognitiveservices.azure.com/text/analytics/v3.1/sentiment";
        String apiKey = "EsBSWwwF5X7tAuIAtJqkc0vg8Efmt7qoxVdn2VDLphCQ3ABOijMBJQQJ99BJACZoyfiXJ3w3AAAaACOGvRiE";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine();
        scanner.close();

         String jsonBody = """
        {
          "documents": [
            {"id": "1", "language": "pt", "text": "%s"}
          ]
        }
        """.formatted(frase);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .header("Content-Type", "application/json")
                .header("Ocp-Apim-Subscription-Key", apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Resultado da análise de sentimento:");
        System.out.println(response.body());
    }
}
