package ru.forinnyy.pizzeria.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public final class OrderEvent {

    private Order order;

    private User userId;

    public OrderEvent(Order order) {
        this.order = order;
    }

}
