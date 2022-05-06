package com.melita.task.application;

import com.melita.task.domain.Order;

public interface MelitaOrderAcceptingService {
    void acceptOrder(Order order);
}
