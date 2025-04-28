package com.progWeb.spring.progWeb.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteBuscarJogadorAPI {

    public static void main(String[] args) throws Exception {
        // Instanciar o cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Definir o ID que você quer buscar
        Long idJogador = 1L; // Mude esse valor conforme o jogador que quiser buscar

        // Montar a requisição GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/jogadores/" + idJogador))
                .GET()
                .build();

        // Enviar a requisição e receber a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Imprimir o status e o corpo da resposta
        System.out.println("Status da resposta: " + response.statusCode());
        System.out.println("Corpo da resposta:");
        System.out.println(response.body());
    }
}
