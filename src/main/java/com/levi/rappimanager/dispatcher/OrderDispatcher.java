package com.levi.rappimanager.dispatcher;

import com.levi.rappimanager.dto.OrderDTO;
import com.levi.rappimanager.listener.OrderCreateListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDispatcher {

    private final List<OrderCreateListener> orderCreateListeners;

    @Autowired
    public OrderDispatcher(List<OrderCreateListener> orderCreateListeners) {
        this.orderCreateListeners = orderCreateListeners;
    }

    public void notifyOrderCreateListeners(OrderDTO order) {
        if (orderCreateListeners != null) {
            for (OrderCreateListener listener : orderCreateListeners) {
                listener.orderWasCreate(order);
            }
        }
    }

}
