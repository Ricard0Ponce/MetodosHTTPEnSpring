package com.trinity.demo2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    // NOTA: Los getters y setters son importantes para permitir crear la instancia
    // de los objetos con sus datos
    @JsonProperty("c-nombre") // Esta anotacion me permite otorgarle nombre a la variable, en este caso al
                              // usar el endpoint podemos pasar este nombre de variables
    private String nombreCliente;
    @JsonProperty("p-nombre")
    private String nombreProducto;
    @JsonProperty("cantidad")
    private int cantidad;

    // Convertimos a String
    @Override
    public String toString() {
        return "Order [nombreCliente=" + nombreCliente + ", nombreProducto=" + nombreProducto + ", cantidad=" + cantidad
                + "]";
    }

    // GETERS Y SETTERS
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
