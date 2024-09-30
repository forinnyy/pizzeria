package ru.forinnyy.pizzeria.command.product;

public final class ProductListCommand extends AbstractProductCommand {

    @Override
    public String getName() {
        return "product-list";
    }

    @Override
    public void execute() {
        serviceLocator.getProductService().list();
    }

}
