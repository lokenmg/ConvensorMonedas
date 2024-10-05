package com.menciasrodrigo.models;

public record MonedaEntity(String moneda, double valor) {
public MonedaEntity(String moneda, double valor) {
    this.moneda = moneda;
    this.valor  = valor;
}


}
