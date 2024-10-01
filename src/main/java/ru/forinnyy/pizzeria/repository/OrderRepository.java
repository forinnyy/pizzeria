package ru.forinnyy.pizzeria.repository;

import ru.forinnyy.pizzeria.api.repository.IOrderRepository;
import ru.forinnyy.pizzeria.enumerated.OrderPickupType;
import ru.forinnyy.pizzeria.model.Order;
import ru.forinnyy.pizzeria.model.OrderEvent;
import ru.forinnyy.pizzeria.service.NotificationObserver;

public final class OrderRepository extends AbstractRepository<Order> implements IOrderRepository {

    @Override
    public Order create(String productId, OrderPickupType orderPickupType) {
        final Order order = new Order();
        order.setProductId(productId);
        order.setOrderPickupType(orderPickupType);
        final OrderEvent orderEvent = new OrderEvent(order);
        NotificationObserver notificationObserver = new NotificationObserver();
        notificationObserver.accept(orderEvent);
        return add(order);
    }

}
