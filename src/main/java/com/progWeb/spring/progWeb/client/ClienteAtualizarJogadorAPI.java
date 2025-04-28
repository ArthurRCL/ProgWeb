package com.progWeb.spring.progWeb.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteAtualizarJogadorAPI {

    public static void main(String[] args) throws Exception {
        // Instanciar o cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Definir o ID do jogador que queremos atualizar
        Long idJogador = 1L; // Mude para o ID correto que você quer alterar

        // Criar o novo JSON atualizado
        String jsonAtualizado = """
            {
              "nome": "Kobe Bryant",
              "posicao": "Ala-armador",
              "dataNascimento": "1978-08-23",
              "nacionalidade": "Americano",
              "ativo": false,
              "altura": "1.98m",
              "numero": 24
            }
            """;

        // Montar a requisição PUT
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/jogadores/" + idJogador))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonAtualizado))
                .build();

        // Enviar a requisição e capturar a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Imprimir o status e o corpo da resposta
        System.out.println("Status da resposta: " + response.statusCode());
        System.out.println("Corpo da resposta:");
        System.out.println(response.body());
    }
}
