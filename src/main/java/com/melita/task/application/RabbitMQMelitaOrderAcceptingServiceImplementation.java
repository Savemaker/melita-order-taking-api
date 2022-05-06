package com.melita.task.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.melita.task.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class RabbitMQMelitaOrderAcceptingServiceImplementation implements MelitaOrderAcceptingService {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @Value("${ACCEPT_ORDER_EXCHANGE_NAME:x.accept-order}")
    private String exchange;

    @Override
    public void acceptOrder(Order order) {
        try {
            rabbitTemplate.convertAndSend(exchange, "", objectMapper.writeValueAsString(order));
        } catch (JsonProcessingException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error serializing order as json");
        } catch (AmqpException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "RabbitMQ failure:" + e.getMessage());
        }
    }
}
