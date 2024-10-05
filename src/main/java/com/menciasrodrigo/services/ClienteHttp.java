package com.menciasrodrigo.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.menciasrodrigo.models.ApiResponse;

public class ClienteHttp {
// Setting URL
String url_str = "https://v6.exchangerate-api.com/v6/ac5a45717dc44ece52e64d23/latest/";

public void creandoConexion(String moneda){

    try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url_str + moneda))
        .GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        GsonMoneda gson = new GsonMoneda();
        ApiResponse apiResponse = gson.obtenerRespuestas(response.body());
        
        System.out.println(apiResponse);


    } catch (Exception e) {
        // TODO: handle exception
    }

    
}


}
