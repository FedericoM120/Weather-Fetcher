import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class Main {
    public static void main(String[] args) {
        String apiKey = "5b4efc2776afd6c2f05e5e364a88e67f";
        String cityName = "Miami";
        String stateCode = "Fl";
        String countryCode = "US";
        int limit = 3;
        double latitude = 25.761681;
        double longitude = -80.191788;

        try {
            String apiURL = "https://api.openweathermap.org/data/2.5/weather?lat=25.76&lon=-80.19&appid=" + apiKey;

            URL url = new URL(apiURL);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            BufferedReader reader;
            if (responseCode == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("Response data:\n" + response.toString());

            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
