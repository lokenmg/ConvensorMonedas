package com.menciasrodrigo.services;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.menciasrodrigo.models.ApiResponse;
import com.menciasrodrigo.models.MonedaEntity;

public class ControlMonedas {


    public ApiResponse obtenerRespuestas (String json){
        Gson gson = new Gson();
        ApiResponse apiResponse = gson.fromJson(json, ApiResponse.class); 
        return apiResponse;
    }

    
    public List<MonedaEntity> crearMonedas (ApiResponse respuesta){
        Map<String, Double> responseMap = new HashMap<String, Double>();
        List<MonedaEntity> monedas = new ArrayList<>();
        responseMap = respuesta.conversion_rates();

        for (Map.Entry<String, Double> responseMaps : responseMap.entrySet()) {
            monedas.add(new MonedaEntity(responseMaps.getKey(), responseMaps.getValue()));
        }
        return monedas;
    }

    public double cambio(List<MonedaEntity> monedas, String moneda, double cantidad){
        double conversion = 0;
        for (MonedaEntity monedaEntity : monedas) {
            if (monedaEntity.moneda().equals(moneda)) {
                conversion = (monedaEntity.valor() * cantidad);
            }
        }
        return conversion;
    }

    public void mostrarResultado(double cantidad, double conversion, String moneda1, String moneda2){
        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println("El valor de: " + df.format(cantidad) + " [ " + moneda1 + " ] " + "corresponde al valor final de ==>> " + df.format(conversion) + " [ "
            + moneda2 +" ] ");
    }
}
