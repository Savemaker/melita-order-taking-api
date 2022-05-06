package com.melita.task.application.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    private final CachingConnectionFactory cachingConnectionFactory;

    @Value("${ACCEPT_ORDER_EXCHANGE_NAME:x.accept-order}")
    private String exchange;

    @Value("${ORDERING_FULFILMENT_QUEUE_NAME:q.ordering-fulfilment}")
    private String orderingFulfilmentSystemQueueName;

    @Value("${ORDERING_FULFILMENT_ROUTING_KEY:ordering-fulfilment}")
    private String orderingFulfilmentRoutingKey;

    @Value("${CARE_SYSTEM_QUEUE_NAME:q.care-system}")
    private String careSystemQueueName;

    @Value("${CARE_SYSTEM_ROUTING_KEY:care-system}")
    private String careSystemRoutingKey;

    public RabbitMQConfig(CachingConnectionFactory cachingConnectionFactory) {
        this.cachingConnectionFactory = cachingConnectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(cachingConnectionFactory);
    }

    @Bean
    Declarables createAcceptingOrderSchema() {
        return new Declarables(
                new FanoutExchange(exchange),
                new Queue(orderingFulfilmentSystemQueueName),
                new Queue(careSystemQueueName),
                new Binding(orderingFulfilmentSystemQueueName, Binding.DestinationType.QUEUE, exchange, orderingFulfilmentRoutingKey, null),
                new Binding(careSystemQueueName, Binding.DestinationType.QUEUE, exchange, careSystemRoutingKey, null)
        );
    }
}
