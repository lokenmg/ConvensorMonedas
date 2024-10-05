package com.menciasrodrigo.models;

import java.util.Map;

public record ApiResponse(String result, Map<String, Double> conversion_rates) {


    
    @Override
    public final String toString() {
        return result + conversion_rates.toString();
    }
} 