package com.LaParcelaStudio.SmashReview.service;

import com.LaParcelaStudio.SmashReview.DTO.TournamentDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
public class TournamentService {

    private final HttpGraphQlClient graphQlClient;



    public TournamentService(@Value("${startGG.token}") String token) {
        WebClient client = WebClient.builder()
                .baseUrl("https://api.start.gg/gql/alpha")
                .defaultHeader("Authorization",token)
                .build();
        graphQlClient = HttpGraphQlClient.builder(client).build();
    }

    public Mono<List<TournamentDTO>> getTournaments() {
        String document = """
            query TournamentsByCountry($cCode: String!, $perPage: Int!) {
              tournaments(query: {
                perPage: $perPage
                filter: {
                  countryCode: $cCode
                }
              }) {
                nodes {
                  id
                  name
                  countryCode
                }
              }
            }
            """;

        // Variables para la consulta GraphQL
        Map<String, Object> variables = Map.of(
                "cCode", "DO",
                "perPage", 4
        );


        return graphQlClient.document(document)
                .variables(variables)
                .retrieve("tournaments.nodes")
                .toEntityList(TournamentDTO.class);
    }
}
