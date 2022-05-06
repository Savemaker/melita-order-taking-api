package com.milita.task.api;

import com.milita.task.domain.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/melita")
public class MelitaController {

    @PostMapping("/order")
    Mono<String> postMelitaOrder(@RequestBody @Valid Order order) {
        return Mono.just("OK");
    }
}
