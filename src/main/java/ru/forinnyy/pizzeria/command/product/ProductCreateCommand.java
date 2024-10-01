package ru.forinnyy.pizzeria.command.product;

import ru.forinnyy.pizzeria.api.service.IServiceLocator;
import ru.forinnyy.pizzeria.enumerated.ProductType;
import ru.forinnyy.pizzeria.model.Ingredient;
import ru.forinnyy.pizzeria.model.Product;
import ru.forinnyy.pizzeria.util.InputUtil;

import java.util.HashMap;
import java.util.Map;

public final class ProductCreateCommand extends AbstractProductCommand {

    @Override
    public String getName() {
        return "product-create";
    }

    @Override
    public void execute() {
        System.out.println("ENTER PRODUCT TYPE: [PIZZA, SNACK, DRINK]");
        final String type = InputUtil.nextLine();
        System.out.println("ENTER PRODUCT NAME: ");
        final String name = InputUtil.nextLine();
        System.out.println("ENTER PRODUCT DESCRIPTION: ");
        final String description = InputUtil.nextLine();

        serviceLocator.getProductService().create(ProductType.valueOf(type), name, description);

    }

}
