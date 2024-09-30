package ru.forinnyy.pizzeria.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.forinnyy.pizzeria.enumerated.ProductType;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public final class Product extends AbstractModel {

    private ProductType productType;

    private String name;

    private String description;

    private Map<Ingredient, Integer> ingredients;

    public Product(ProductType productType, String name, String description, Map<Ingredient, Integer> ingredients) {
        this.productType = productType;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

}
