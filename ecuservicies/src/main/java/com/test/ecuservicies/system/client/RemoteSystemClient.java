package com.test.ecuservicies.system.client;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.test.ecuservicies.system.dto.GetStatusRequest;
import com.test.ecuservicies.system.dto.GetStatusResponse;
import com.test.ecuservicies.system.dto.MineducDisableRequest;
import com.test.ecuservicies.system.dto.MineducDisableResponse;
import com.test.ecuservicies.system.dto.MineducPasswordRequest;
import com.test.ecuservicies.system.dto.MineducPasswordResponse;
import com.test.ecuservicies.system.dto.MineducRecoveryRequest;
import com.test.ecuservicies.system.dto.MineducRecoveryResponse;
import com.test.ecuservicies.system.dto.MineducRequest;
import com.test.ecuservicies.system.dto.MineducResponse;
import com.test.ecuservicies.system.dto.NewEmergencyRequest;
import com.test.ecuservicies.system.dto.NewEmergencyResponse;
import com.test.ecuservicies.system.dto.NewRegisterRequest;
import com.test.ecuservicies.system.dto.NewRegisterResponse;
import com.test.ecuservicies.system.dto.SetCanceladoRequest;
import com.test.ecuservicies.system.dto.SetCanceladoResponse;

import reactor.core.publisher.Mono;

@Component
public class RemoteSystemClient {

    private final WebClient webClient;

    public RemoteSystemClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://10.121.5.232:8081/middleware/geolocalizacion").build();
    }

    /**
     * Llama al servicio remoto de forma asíncrona.
     * Devuelve un "Mono", que es una promesa de que la respuesta llegará en el
     * futuro.
     */
    // public Mono<NewEmergencyResponse> newEmergencyRemote(NewEmergencyRequest
    // request) {
    // return webClient.post()
    // .uri("/ip") // Endpoint
    // .bodyValue(request)
    // .retrieve()
    // // Manejo de errores: Si el status es 4xx o 5xx, lanza una excepción
    // .onStatus(HttpStatusCode::isError, clientResponse ->
    // clientResponse.bodyToMono(String.class)
    // .flatMap(errorBody -> Mono
    // .error(new RuntimeException("Error en servicio remoto: " + errorBody))))
    // // Convierte el cuerpo de la respuesta a nuestro DTO de respuesta
    // .bodyToMono(NewEmergencyResponse.class)
    // .doOnNext(resp -> System.out.println("Response desde el middleware: " +
    // resp))
    // .log();
    // }
    public NewEmergencyResponse newEmergency(NewEmergencyRequest request) {
        return webClient.post()
                .uri("/newEmergency")
                .bodyValue(request)
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new ResponseStatusException(clientResponse.statusCode(), errorBody))))
                .onStatus(HttpStatusCode::isError, clientResponse -> clientResponse.bodyToMono(String.class)
                        .flatMap(errorBody -> Mono
                                .error(new RuntimeException("Error remoto: " + errorBody))))
                .bodyToMono(NewEmergencyResponse.class)
                .block();
    }

    public NewRegisterResponse newRegister(NewRegisterRequest request) {
        return webClient.post()
                .uri("/register")
                .bodyValue(request)
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new ResponseStatusException(clientResponse.statusCode(), errorBody))))
                .onStatus(HttpStatusCode::isError, clientResponse -> clientResponse.bodyToMono(String.class)
                        .flatMap(errorBody -> Mono.error(new RuntimeException("Error remoto: " + errorBody))))
                .bodyToMono(NewRegisterResponse.class)
                .block();
    }

    public GetStatusResponse getStatus(GetStatusRequest request) {
        return webClient.post()
                .uri("/status")
                .bodyValue(request)
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new ResponseStatusException(clientResponse.statusCode(), errorBody))))
                .onStatus(HttpStatusCode::isError, clientResponse -> clientResponse.bodyToMono(String.class)
                        .flatMap(errorBody -> Mono.error(new RuntimeException("Error remoto: " + errorBody))))
                .bodyToMono(GetStatusResponse.class)
                .block();
    }

    public SetCanceladoResponse setCancelado(SetCanceladoRequest request) {
        return webClient.post()
                .uri("/cancelado")
                .bodyValue(request)
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new ResponseStatusException(clientResponse.statusCode(), errorBody))))
                .onStatus(HttpStatusCode::isError, clientResponse -> clientResponse.bodyToMono(String.class)
                        .flatMap(errorBody -> Mono.error(new RuntimeException("Error remoto: " + errorBody))))
                .bodyToMono(SetCanceladoResponse.class)
                .block();
    }

    public MineducResponse mineducLogin(MineducRequest request) {
        return webClient.post()
                .uri("/mineducLogin")
                .bodyValue(request)
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new ResponseStatusException(clientResponse.statusCode(), errorBody))))
                .onStatus(HttpStatusCode::isError, clientResponse -> clientResponse.bodyToMono(String.class)
                        .flatMap(errorBody -> Mono.error(new RuntimeException("Error remoto: " + errorBody))))
                .bodyToMono(MineducResponse.class)
                .block();
    }

    public MineducRecoveryResponse recoveryMineduc(MineducRecoveryRequest request) {
        return webClient.post()
                .uri("/recoveryMineduc")
                .bodyValue(request)
                .retrieve()

                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new ResponseStatusException(clientResponse.statusCode(), errorBody))))
                .onStatus(
                        HttpStatusCode::is5xxServerError,
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new RuntimeException("Error remoto del servidor: " + errorBody))))
                .bodyToMono(MineducRecoveryResponse.class)
                .block();
    }

    public MineducPasswordResponse validarClaveMineduc(MineducPasswordRequest request) {
        return webClient.post()
                .uri("/validarClaveMineduc")
                .bodyValue(request)
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new ResponseStatusException(clientResponse.statusCode(), errorBody))))
                .onStatus(
                        HttpStatusCode::is5xxServerError,
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new RuntimeException("Error remoto del servidor: " + errorBody))))
                .bodyToMono(MineducPasswordResponse.class)
                .block();
    }

    public MineducDisableResponse disableMineduc(MineducDisableRequest request) {
        return webClient.post()
                .uri("/disableMineduc")
                .bodyValue(request)
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new ResponseStatusException(clientResponse.statusCode(), errorBody))))
                .onStatus(
                        HttpStatusCode::is5xxServerError,
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new RuntimeException("Error remoto del servidor: " + errorBody))))
                .bodyToMono(MineducDisableResponse.class)
                .block();
    }

}
