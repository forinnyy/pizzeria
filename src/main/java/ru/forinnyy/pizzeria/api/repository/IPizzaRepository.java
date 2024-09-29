package ru.forinnyy.pizzeria.api.repository;

import ru.forinnyy.pizzeria.model.Product;

public interface IPizzaRepository {

    Product create(String userId, String name, String description);

}
