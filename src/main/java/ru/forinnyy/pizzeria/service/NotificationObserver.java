package ru.forinnyy.pizzeria.service;

import ru.forinnyy.pizzeria.api.service.Observer;
import ru.forinnyy.pizzeria.model.OrderEvent;

public final class NotificationObserver implements Observer {

    @Override
    public void accept(OrderEvent orderEvent) {
        System.out.println(orderEvent.getOrder().getDate());
        System.out.println(orderEvent.getOrder().getProductId());
        System.out.println(orderEvent.getOrder().getOrderPickupType());
        System.out.println(orderEvent.getOrder().getId());
    }

}
