package com.trinity.demo2;

//Esta clase nos ahorra los Getters Y Setters de las variables del objeto con el que estemos trabajando 
public record OrderRecord(
    String nombreCliente, 
    String nombreProducto, 
    int cantidad
) {
    
}
