package ru.forinnyy.pizzeria.repository;

import ru.forinnyy.pizzeria.api.repository.IRepository;
import ru.forinnyy.pizzeria.model.AbstractModel;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractRepository<M extends AbstractModel> implements IRepository<M> {

    final Map<String, M> models = new LinkedHashMap<>();

    public M add(final M model) {
        models.put(model.getId(), model);
        return model;
    }

    public void list() {
        System.out.println(models.keySet());
        System.out.println(models.values());
    }

}
