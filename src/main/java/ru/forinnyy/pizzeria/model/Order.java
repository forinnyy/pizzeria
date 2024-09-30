package ru.forinnyy.pizzeria.model;

import lombok.Getter;
import ru.forinnyy.pizzeria.enumerated.OrderPickupType;

import java.util.Date;

@Getter
public final class Order extends AbstractModel {

    final Product productId;

    final Date date = new Date();

    OrderPickupType orderPickupType;

    public Order(Product pizza, OrderPickupType orderPickupType) {
        this.productId = pizza;
        this.orderPickupType = orderPickupType;
    }

}
