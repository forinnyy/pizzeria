package ru.forinnyy.pizzeria.service;

import ru.forinnyy.pizzeria.api.repository.IOrderRepository;
import ru.forinnyy.pizzeria.api.service.IOrderService;
import ru.forinnyy.pizzeria.enumerated.OrderPickupType;
import ru.forinnyy.pizzeria.model.Order;

public final class OrderService extends AbstractService<Order, IOrderRepository>
        implements IOrderService {

    public OrderService(IOrderRepository repository) {
        super(repository);
    }

    @Override
    public Order create(String productId, OrderPickupType orderPickupType) {
        return repository.create(productId, orderPickupType);
    }

}
