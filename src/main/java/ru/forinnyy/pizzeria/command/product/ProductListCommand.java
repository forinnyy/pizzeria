package ru.forinnyy.pizzeria.command.product;

import ru.forinnyy.pizzeria.model.Product;

import java.util.LinkedList;
import java.util.List;

public final class ProductListCommand extends AbstractProductCommand {

    @Override
    public String getName() {
        return "product-list";
    }

    @Override
    public void execute() {
        List<Product> products = new LinkedList<>(serviceLocator.getProductService().list());
        List<String> productNames = new LinkedList<>();
        for (Product product : products) {
            productNames.add(product.getName());
        }
        System.out.println(productNames);
    }

}
