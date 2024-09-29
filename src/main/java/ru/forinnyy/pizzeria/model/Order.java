package ru.forinnyy.pizzeria.model;

import ru.forinnyy.pizzeria.enumerated.OrderPickupType;

import java.util.Date;

public final class Order extends AbstractModel {

    final Product pizza;

    final User user;

    final Date date = new Date();

    OrderPickupType orderPickupType;

    public Order(Product pizza, User user, OrderPickupType orderPickupType) {
        this.pizza = pizza;
        this.user = user;
        this.orderPickupType = orderPickupType;
    }

}
