package com.aluracursos.challengeLiteralura.servicio;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ConsumoApi {


    private final HttpClient client;


    public ConsumoApi() {
        this.client = HttpClient.newHttpClient();
    }


    public String obtenerDatos(String url) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response;
        try {

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {

            throw new ApiException("Error al obtener datos de la URL: " + url, e);
        }


        return response.body();
    }
}


class ApiException extends RuntimeException {


    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
