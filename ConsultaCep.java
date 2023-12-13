package org.example;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep extends RuntimeException {

    public Endereco buscaEndereco(String cep) {

        URI enderecoWeb = URI.create("https://viacep.com.br/ws/" + cep + "/json");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(enderecoWeb)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter o endereço a partir deste CEP.");
        }
    }
}

