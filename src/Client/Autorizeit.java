package Client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Autorizeit {

    String login;
    String pass;

    public Autorizeit(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public void toPhpService() throws IOException {
        Gson gson = new Gson();

        String str = "http://192.168.0.108/Authorization/auth.php?data=";

        Entity entity = new Entity(login,pass,"xz");

        String json = gson.toJson(entity);

        str += json;
        System.out.println(str + " - S T R ");

        URL url = new URL(str);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());

    }
}
