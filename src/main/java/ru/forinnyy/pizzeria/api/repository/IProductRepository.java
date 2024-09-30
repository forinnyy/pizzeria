package ru.forinnyy.pizzeria.api.repository;

import ru.forinnyy.pizzeria.enumerated.ProductType;
import ru.forinnyy.pizzeria.model.Ingredient;
import ru.forinnyy.pizzeria.model.Product;

import java.util.Map;

public interface IProductRepository extends IRepository<Product> {

    Product create(ProductType productType, String name, String description);

    Product create(ProductType productType, String name, String description, Map<Ingredient, Integer> ingredients);

}
