package ru.forinnyy.pizzeria.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.forinnyy.pizzeria.enumerated.OrderPickupType;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public final class Order extends AbstractModel {

    private String productId;

    private final Date date = new Date();

    private OrderPickupType orderPickupType;

    public Order(String productId, OrderPickupType orderPickupType) {
        this.productId = productId;
        this.orderPickupType = orderPickupType;
    }

}
