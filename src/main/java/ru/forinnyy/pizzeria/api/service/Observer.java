package ru.forinnyy.pizzeria.api.service;

import ru.forinnyy.pizzeria.model.OrderEvent;

public interface Observer {

    void accept(OrderEvent orderEvent);

}
