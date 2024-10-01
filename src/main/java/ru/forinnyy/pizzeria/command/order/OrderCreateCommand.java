package ru.forinnyy.pizzeria.command.order;

import ru.forinnyy.pizzeria.enumerated.OrderPickupType;
import ru.forinnyy.pizzeria.model.Product;
import ru.forinnyy.pizzeria.util.InputUtil;

import java.util.LinkedList;
import java.util.List;

public final class OrderCreateCommand extends AbstractOrderCommand {

    @Override
    public String getName() {
        return "order-create";
    }

    @Override
    public void execute() {
        List<Product> products = new LinkedList<>(serviceLocator.getProductService().list());
        List<String> productNames = new LinkedList<>();
        for (Product product : products) {
            productNames.add(product.getName());
        }
        System.out.println("ENTER PRODUCT: " + productNames);
        final String name = InputUtil.nextLine();
        String id = null;
        for (Product product : products) {
            if (name.equals(product.getName())) id = product.getId();
        }


        System.out.println("ENTER PICKUP TYPE: [TAKEAWAY, DINEIN, DELIVERY]");
        final String type = InputUtil.nextLine();
        serviceLocator.getOrderService().create(id, OrderPickupType.valueOf(type));
    }

}
