package com.melita.task.api;

import com.melita.task.application.MelitaOrderAcceptingService;
import com.melita.task.application.authentication.AuthenticationService;
import com.melita.task.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/melita")
@RequiredArgsConstructor
public class MelitaController {
    private static final String AUTH_HEADER = "X-Auth-Token";
    private final AuthenticationService authenticationService;
    private final MelitaOrderAcceptingService melitaOrderAcceptingService;

    @PostMapping("/order")
    Mono<ResponseEntity<Map<String, String>>> postMelitaOrder(@RequestHeader(name = AUTH_HEADER, required = false) String authHeader, @RequestBody @Valid Order order) {
        authenticationService.checkAuthentication(authHeader);
        melitaOrderAcceptingService.acceptOrder(order);
        return Mono.just(
                ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(Map.of(
                                "result", "Your order has been accepted!",
                                "time", LocalDateTime.now().toString()
                        )));
    }
}
