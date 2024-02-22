package com.trinity.demo2;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController // Agregamos esta etiqueta para definir que este es un control para rest.
public class FirstController {

    // Para crear un endpoint, primero definimos el verbo del metodo HTTP para el
    // endpoint
    //@GetMapping("/hello") // Declaramos la ruta del endpoint
    public String sayHello() {
        return "Hello from my first controller";
    }

    // Post permite enviar información del cliente al servidor
    @PostMapping("/post")
    public String post(
            // Le damos el cuerpo de la peticion, es decir lo que va a enviar y en que orden
            @RequestBody String massege // No lleva punto y coma, es paso de parametro, usamos RequestBody para indicar
                                        // que es el cuerpo de la solicitud
    ) {
        return "Request Accepted and messege is: " + massege;
    }

    // Post permite enviar información del cliente al servidor
    @PostMapping("/post-order")
    public String postOrder(
            // Le damos el cuerpo de la peticion, es decir lo que va a enviar y en que orden
            @RequestBody Order order// No lleva punto y coma, es paso de parametro, usamos RequestBody para indicar
                                    // que es el cuerpo de la solicitud
    ) {
        return "Request Accepted and messege is: " + order.toString(); // Pasamos el objeto a String
    }

    // USANDO RECORD OBTENEMOS:

    // Mismo proceso que post-order pero usando record
    @PostMapping("/post-order-record")
    public String postRecord(
            // Le damos el cuerpo de la peticion, es decir lo que va a enviar y en que orden
            @RequestBody OrderRecord order// Usando Record, se necesita Java 16 o superior
    ) {
        return "Request Accepted and messege is: " + order.toString(); // Pasamos el objeto a String
    }

    //Endpoint que usa la ruta (path) para el cuerpo de la peticion
    //Se usa de la siguiente forma:
    // http://localhost:8080/hello/variableAPasar
    //@GetMapping("/hello/{user-name}") // Se pone en {} el valor que se le vaya a pasar al endpoint
    public String pathVar(
        @PathVariable("user-name") String userName //Aqui se necesita PathVariable para decir que esta es la variable
    ) {
        return "My value = "+userName;
    }
    
    //USANDO PARAM, los datos se pasan de manera diferente en la URL
    //La forma en la que se usa este endpoint es de la siguiente forma: 
    // http://localhost:8080/hello?param_name=paramvalue&param_name2=value2 
    @GetMapping("/hello") // En este caso se usa solo el endpoint sin {}
    public String paramVar(
        @RequestParam("user-name") String userName, //Usamos RequestParam cuando no se usa el envio del dato por medio de {}
        @RequestParam("user-lastname") String userLastName
    ) {
        return "My value = "+userName+" "+userLastName ;
    }

    /*
     * @GetMapping("/hello-2") //Mapeamos el endpoint con ese nombre
     * 
     * @ResponseStatus(HttpStatus.ACCEPTED) //Como respuesta damos ACCEPTED a este
     * endpoint
     * //Al hacer lo anterior, podremos ver en la consola que regresa el valor 202
     * public String sayHello2() {
     * return "Hello 2 from my first controller"; //Elemento que regresa el endpoint
     * al ejecutarse correctamente
     * }
     * 
     */



     /////NOTAS //////////
     /*
      * Usamos PathVariable cuando pasamos el parametro desde la URI, es decir que solo tendremos ese valor identificativo
      
      Por otro lado, usamos RequestParam cuando extraemos parametros desde query, que tambien se encuentran en la URL
      Los parametros de tipo Query, son parametros usados tipicamente para traer informacion que nos de contexto
      Usa los valores de ? y = para poder asignar valores a los parametros. 
    
      Note que estos 2 Parametros se usan para el Get y para Post se usa el RequestBody dado que vamos a almacenar un tipo de informacion con ello
      En resumen PathVariable es usado cuando el valor es parte del URI, mientras que 
      RequestParam se usa cuando el valor se pasa como parametro de la consulta
      */

}
