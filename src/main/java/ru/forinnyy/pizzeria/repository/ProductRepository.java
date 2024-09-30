package ru.forinnyy.pizzeria.repository;

import ru.forinnyy.pizzeria.api.repository.IProductRepository;
import ru.forinnyy.pizzeria.enumerated.ProductType;
import ru.forinnyy.pizzeria.model.Ingredient;
import ru.forinnyy.pizzeria.model.Product;

import java.util.Map;

public final class ProductRepository extends AbstractRepository<Product>
        implements IProductRepository {

    @Override
    public Product create(ProductType productType, String name, String description) {
        final Product product = new Product();
        product.setProductType(productType);
        product.setName(name);
        product.setDescription(description);
        return add(product);
    }

    @Override
    public Product create(ProductType productType, String name, String description, Map<Ingredient, Integer> ingredients) {
        final Product product = new Product();
        product.setProductType(productType);
        product.setName(name);
        product.setDescription(description);
        product.setIngredients(ingredients);
        return add(product);
    }

}
