package com.levi.rappimanager.listener;

import com.levi.rappimanager.dto.OrderDTO;

public interface OrderCreateListener {

    void orderWasCreate(OrderDTO orderDTO);

}
