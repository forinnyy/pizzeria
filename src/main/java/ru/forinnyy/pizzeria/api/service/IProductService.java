package ru.forinnyy.pizzeria.api.service;

import ru.forinnyy.pizzeria.api.repository.IRepository;
import ru.forinnyy.pizzeria.enumerated.ProductType;
import ru.forinnyy.pizzeria.model.Ingredient;
import ru.forinnyy.pizzeria.model.Product;

import java.util.Map;

public interface IProductService extends IRepository<Product> {

    Product create(ProductType productType, String name, String description);

    Product create(ProductType productType, String name, String description, Map<Ingredient, Integer> ingredients);

}
