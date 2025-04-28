package com.progWeb.spring.progWeb.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteJogadorAPI {

    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        String json = """
            {
              "nome": "Michael Jordan",
              "posicao": "Ala-armador",
              "dataNascimento": "1963-02-17",
              "nacionalidade": "Americano",
              "ativo": false,
              "altura": "1.98m",
              "numero": 23
            }
            """;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/jogadores"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status da resposta: " + response.statusCode());
        System.out.println("Corpo da resposta: " + response.body());
    }
}
