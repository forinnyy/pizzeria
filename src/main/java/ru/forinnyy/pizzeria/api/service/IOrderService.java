package ru.forinnyy.pizzeria.api.service;

import ru.forinnyy.pizzeria.api.repository.IRepository;
import ru.forinnyy.pizzeria.enumerated.OrderPickupType;
import ru.forinnyy.pizzeria.model.Order;

public interface IOrderService extends IRepository<Order> {

    Order create(String productId, OrderPickupType orderPickupType);

}
