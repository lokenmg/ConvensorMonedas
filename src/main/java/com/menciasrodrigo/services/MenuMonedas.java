package com.menciasrodrigo.services;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuMonedas {

    public void menu() {

        // variables
        int opcion = 1;
        double cantidad = 1;
        double conversion = 1;

        // instancias
        Scanner sc = new Scanner(System.in);

        while (opcion > 0 && opcion < 9) {
            ClienteHttp clienteHttp = new ClienteHttp();
            ControlMonedas controlMonedas = new ControlMonedas();

            System.out.println("*************************************************");

            System.out.println("\n Sea Bienvenido/a al Conversor de Moneda \n");

            System.out.println("*************************************************");

            System.out.println("Elija lo que necesite hacer:");

            System.out.println("1) Dólar          ==>> Pesoargentino");
            System.out.println("2) Peso Argentino ==>> Dólar");
            System.out.println("3) Dólar          ==>> Real brasileño");
            System.out.println("4) Real Brasileño ==>> Dólar");
            System.out.println("5) Dólar          ==>> Peso colombiano");
            System.out.println("6) Peso clombiano ==>> Dólar");
            System.out.println("7) Dólar          ==>> Peso mexicano0");
            System.out.println("8) Peso mexicano  ==>> Dólar");
            System.out.println("0) Salir");

            try {
                opcion = sc.nextInt();

                if (opcion<1 || opcion> 8 ) {
                    break;
                }

                System.out.println("Ingrese eol valor que quiera convertir");
                cantidad = sc.nextDouble();
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("error: " + e);
                System.out.println("Por favor ingrese un número valido");
                break;
            }

            

            {
                switch (opcion) {
                    case 1:
                        conversion = controlMonedas.cambio(clienteHttp.creandoConexion("USD"), "ARS", cantidad);
                        controlMonedas.mostrarResultado(cantidad, conversion, "USD", "ARS");
                        break;

                    case 2:
                        conversion = controlMonedas.cambio(clienteHttp.creandoConexion("ARS"), "USD", cantidad);
                        controlMonedas.mostrarResultado(cantidad, conversion, "ARS", "USD");
                        break;

                    case 3:
                        conversion = controlMonedas.cambio(clienteHttp.creandoConexion("USD"), "BRL", cantidad);
                        controlMonedas.mostrarResultado(cantidad, conversion, "USD", "BRL");
                        break;

                    case 4:
                        conversion = controlMonedas.cambio(clienteHttp.creandoConexion("BRL"), "USD", cantidad);
                        controlMonedas.mostrarResultado(cantidad, conversion, "BRL", "USD");
                        break;
                    case 5:
                        conversion = controlMonedas.cambio(clienteHttp.creandoConexion("USD"), "COP", cantidad);
                        controlMonedas.mostrarResultado(cantidad, conversion, "USD", "COP");
                        break;
                    case 6:
                        conversion = controlMonedas.cambio(clienteHttp.creandoConexion("COP"), "USD", cantidad);
                        controlMonedas.mostrarResultado(cantidad, conversion, "COP", "USD");
                        break;
                    case 7:
                        conversion = controlMonedas.cambio(clienteHttp.creandoConexion("USD"), "MXN", cantidad);
                        controlMonedas.mostrarResultado(cantidad, conversion, "USD", "MXN");
                        break;
                    case 8:
                        conversion = controlMonedas.cambio(clienteHttp.creandoConexion("MXN"), "USD", cantidad);
                        controlMonedas.mostrarResultado(cantidad, conversion, "MXN", "USD");
                        break;
                    default:

                    break;
                }
            }
        }
    }
}
