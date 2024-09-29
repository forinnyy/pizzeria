package ru.forinnyy.pizzeria.command.product;

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
        System.out.println("[SYSTEM] CREATE PRODUCT COMMAND [EXECUTED]");

        System.out.println("ENTER PRODUCT TYPE: [PIZZA, SNACK, DRINK]");
        final String type = InputUtil.nextLine();
        System.out.println("ENTER PRODUCT NAME: ");
        final String name = InputUtil.nextLine();
        System.out.println("ENTER PRODUCT DESCRIPTION: ");
        final String description = InputUtil.nextLine();

        System.out.println("ENTER AMOUNT OF INGREDIENTS:");
        final Integer countOfIngredients = InputUtil.nextNumber();
        final Map<Ingredient, Integer> ingredients = new HashMap<>();

        for (Integer i = countOfIngredients; i > 0; i--) {
            System.out.println("ENTER INGREDIENT NAME: ");
            final Ingredient ingredient = new Ingredient(InputUtil.nextLine());
            System.out.println("ENTER INGREDIENT AMOUNT: ");
            final Integer amountOfIngredient = InputUtil.nextNumber();
            ingredients.put(ingredient, amountOfIngredient);
        }

        final Product peperoni = new Product(ProductType.valueOf(type), name, description, ingredients);
        System.out.println();
        System.out.println("[SYSTEM] CREATE PRODUCT COMMAND [FINISHED]");
        System.out.println();
        System.out.println("PRODUCT " + peperoni.getName() + " CREATED");
        System.out.println("INGREDIENTS: ");
        for (Integer i = countOfIngredients; i > 0; i--) {
            System.out.println(ingredients.keySet());
        }
        System.out.println();
    }

}
