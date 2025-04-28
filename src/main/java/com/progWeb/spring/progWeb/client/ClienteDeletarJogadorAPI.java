package com.progWeb.spring.progWeb.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteDeletarJogadorAPI {

    public static void main(String[] args) throws Exception {
        // Instanciar o cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Definir o ID do jogador que queremos deletar
        Long idJogador = 4L; // Troque para o ID que você quiser excluir

        // Montar a requisição DELETE
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/jogadores/" + idJogador))
                .DELETE()
                .build();

        // Enviar a requisição e capturar a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Imprimir o status e o corpo da resposta
        System.out.println("Status da resposta: " + response.statusCode());
        System.out.println("Corpo da resposta:");
        System.out.println(response.body());
    }
}
