package ru.forinnyy.pizzeria.api.repository;

import ru.forinnyy.pizzeria.enumerated.OrderPickupType;
import ru.forinnyy.pizzeria.model.Order;

public interface IOrderRepository extends IRepository<Order> {

    Order create(String productId, OrderPickupType orderPickupType);

}
