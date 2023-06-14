package br.com.fatec.n2_poo_pokemenu.services;
import br.com.fatec.n2_poo_pokemenu.model.domain.pokemon;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class pokemonApiClient {
    private static final String API_BASE_URL = "https://pokeapi.co/api/v2/";

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public pokemonApiClient() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public pokemon getPokemonInfo(int pokemonId) throws IOException, InterruptedException {
        String apiUrl = API_BASE_URL + "pokemon/" + pokemonId;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            PokemonApiResponse apiResponse = objectMapper.readValue(response.body(), PokemonApiResponse.class);
            if (apiResponse != null) {
                String[] types = new String[apiResponse.getTypes().length];
                for (int i = 0; i < apiResponse.getTypes().length; i++) {
                    types[i] = apiResponse.getTypes()[i].getType().getName();
                }

                return new pokemon(
                        apiResponse.getId(),
                        apiResponse.getName(),
                        apiResponse.getWeight(),
                        apiResponse.getHeight(),
                        types
                );
            }
        }

        return null;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class PokemonApiResponse {
        private int id;
        private String name;
        private float weight;
        private float height;
        private Type[] types;

        public PokemonApiResponse() {
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public float getWeight() {
            return weight;
        }

        public float getHeight() {
            return height;
        }

        public Type[] getTypes() {
            return types;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Type {
        private TypeDetail type;

        public Type() {
        }

        public TypeDetail getType() {
            return type;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class TypeDetail {
        private String name;

        public TypeDetail() {
        }

        public String getName() {
            return name;
        }
    }
}
