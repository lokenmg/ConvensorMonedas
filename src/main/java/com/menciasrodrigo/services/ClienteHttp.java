package com.menciasrodrigo.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpConnectTimeoutException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.menciasrodrigo.models.ApiResponse;
import com.menciasrodrigo.models.MonedaEntity;

public class ClienteHttp {
// Setting URL
String url_str = "https://v6.exchangerate-api.com/v6/ac5a45717dc44ece52e64d23/latest/";

public List<MonedaEntity> creandoConexion(String moneda){

    try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url_str + moneda))
        .GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ControlMonedas controlMonedas = new ControlMonedas();
        ApiResponse apiResponse = controlMonedas.obtenerRespuestas(response.body());
        
        return controlMonedas.crearMonedas(apiResponse);


    } catch ( InterruptedException| IOException  e) {
        System.out.println("Ocurrio un error: " + e);
        return null;
    }

    
}


}
