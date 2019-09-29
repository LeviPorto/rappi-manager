package com.levi.rappimanager.subscriber;

import com.levi.rappimanager.dispatcher.CoordinateDispatcher;
import com.levi.rappimanager.dto.CoordinateDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CoordinateSubscriber {

    private final CoordinateDispatcher coordinateDispatcher;

    public CoordinateSubscriber(final CoordinateDispatcher coordinateDispatcher) {
        this.coordinateDispatcher = coordinateDispatcher;
    }

    @KafkaListener(topics = "COORDINATE_EVENT_SOURCING", groupId = "1234", containerFactory = "kafkaListenerContainerFactory")
    public void processCoordinateEventSourcing(@Payload CoordinateDTO coordinateDTO) {
        coordinateDispatcher.notifyCoordinateCreateListeners(coordinateDTO);
    }

}
