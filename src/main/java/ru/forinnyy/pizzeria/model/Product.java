package ru.forinnyy.pizzeria.model;

import lombok.Getter;
import ru.forinnyy.pizzeria.enumerated.ProductType;

import java.util.Map;

@Getter
public final class Product extends AbstractModel {

    private final ProductType productType;

    private final String name;

    private final String description;

    private final Map<Ingredient, Integer> ingredients;

    public Product(ProductType productType, String name, String description, Map<Ingredient, Integer> ingredients) {
        this.productType = productType;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

}
