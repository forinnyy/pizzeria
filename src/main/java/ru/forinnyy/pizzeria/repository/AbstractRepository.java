package ru.forinnyy.pizzeria.repository;

import ru.forinnyy.pizzeria.api.repository.IRepository;
import ru.forinnyy.pizzeria.model.AbstractModel;

import java.util.*;

public abstract class AbstractRepository<M extends AbstractModel> implements IRepository<M> {

    final Map<String, M> models = new LinkedHashMap<>();

    public M add(final M model) {
        models.put(model.getId(), model);
        return model;
    }

    public List<M> list() {
        List<M> listModels = new LinkedList<>();
        for (Map.Entry<String, M> entry : models.entrySet()) {
            M model = entry.getValue();
            listModels.add(model);
        }
        return listModels;
    }

}
