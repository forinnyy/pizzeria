package ru.forinnyy.pizzeria.command.order;

import ru.forinnyy.pizzeria.model.Order;
import ru.forinnyy.pizzeria.model.Product;

import java.util.LinkedList;
import java.util.List;

public final class OrderListCommand extends AbstractOrderCommand {

    @Override
    public String getName() {
        return "order-list";
    }

    @Override
    public void execute() {
        List<Order> orders = new LinkedList<>(serviceLocator.getOrderService().list());
        System.out.println("YOUR ORDERS: ");
        for (Order order : orders) {
            System.out.println();
            System.out.println("Order id: " + order.getId());
            System.out.println("Order date: " + order.getDate());
            System.out.println("Order pickup type: " + order.getOrderPickupType());
        }

    }

}
