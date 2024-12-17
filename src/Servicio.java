import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Servicio {

    private String urlBase = "https://v6.exchangerate-api.com/v6/";

    private String claveDeAPI = "953a4f3e9225e8fd14fb44b3";

    public  CoversionResponse obtenerInformacionDeLaApi(String monedaDeOrigen, String monedaDeDestino, int cantidad)throws IOException, InterruptedException {
        //crear una instancia de httpclient
        HttpClient client = HttpClient.newHttpClient();
        //Crear la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlBase + claveDeAPI + "/pair/" + monedaDeOrigen + "/" + monedaDeDestino + "/" + cantidad))
                .build();

        //Enviar la solicitud y obtener la respueesta
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        CoversionResponse conversionResponse = gson.fromJson(response.body(), CoversionResponse.class);
        return conversionResponse;

    }
}