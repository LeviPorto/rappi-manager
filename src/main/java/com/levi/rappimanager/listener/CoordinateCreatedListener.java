package com.levi.rappimanager.listener;

import com.levi.rappimanager.dto.CoordinateDTO;

public interface CoordinateCreatedListener {

    void coordinateWasCreated(CoordinateDTO coordinateDTO);

}
