package com.menciasrodrigo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.menciasrodrigo.models.ApiResponse;
import com.menciasrodrigo.models.MonedaEntity;
public class GsonMoneda {


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

}
