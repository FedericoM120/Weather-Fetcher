import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
public class Main {
    public static void main(String[] args) {
        String apiKey = "5b4efc2776afd6c2f05e5e364a88e67f\n";
        double latitude = 25.761681;
        double longitude = -80.191788;
        String excludeParts = "minutely, hourly, daily, alerts";

        try {
            String apiURL = "https://api.openweathermap.org/data/3.0/onecall?" +
                    "lat=" + latitude +
                    "&lon=" + longitude +
                    "&exclude=" + excludeParts +
                    "&appid=" + apiKey;

            URL url = new URL(apiURL);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            StringBuilder response = new StringBuilder();

            
        } catch (IOException e) {

        }
    }

}
