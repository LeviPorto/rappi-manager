package com.levi.rappimanager.subscriber;

import com.levi.rappimanager.dispatcher.OrderDispatcher;
import com.levi.rappimanager.dto.OrderDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderSubscriber {

    private final OrderDispatcher orderDispatcher;

    public OrderSubscriber(final OrderDispatcher orderDispatcher) {
        this.orderDispatcher = orderDispatcher;
    }

    @KafkaListener(topics = "ORDER_EVENT_SOURCING", groupId = "1234", containerFactory = "kafkaListenerContainerFactory")
    public void processOrderEventSourcing(@Payload OrderDTO orderDTO) {
        orderDispatcher.notifyOrderCreateListeners(orderDTO);
    }

}
