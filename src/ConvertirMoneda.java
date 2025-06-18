import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertirMoneda {

    public Moneda conversion (String monedaDeCambio, String tipoDeCambio){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/801e9d38fed1c331898f5f53/pair/"+monedaDeCambio+"/"+tipoDeCambio);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception error) {
            ;
            System.out.println("ocurrio un error en tu peticion");
            return null;
        }

    }
}