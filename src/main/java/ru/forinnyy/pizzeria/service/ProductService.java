package ru.forinnyy.pizzeria.service;

import ru.forinnyy.pizzeria.api.repository.IProductRepository;
import ru.forinnyy.pizzeria.api.service.IProductService;
import ru.forinnyy.pizzeria.api.service.Observer;
import ru.forinnyy.pizzeria.enumerated.ProductType;
import ru.forinnyy.pizzeria.model.Ingredient;
import ru.forinnyy.pizzeria.model.OrderEvent;
import ru.forinnyy.pizzeria.model.Product;

import java.util.Map;

public final class ProductService extends AbstractService<Product, IProductRepository>
        implements IProductService {

    public ProductService(IProductRepository repository) {
        super(repository);
    }

    @Override
    public Product create(ProductType productType, String name, String description) {
        return repository.create(productType, name, description);
    }

    @Override
    public Product create(ProductType productType, String name, String description, Map<Ingredient, Integer> ingredients) {
        return repository.create(productType, name, description, ingredients);
    }

}
