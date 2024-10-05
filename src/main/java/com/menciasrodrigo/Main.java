package com.menciasrodrigo;

import com.menciasrodrigo.services.ClienteHttp;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ClienteHttp pruebaConexion = new ClienteHttp();

        pruebaConexion.creandoConexion("USD");
        
    }
}