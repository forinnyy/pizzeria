package ru.forinnyy.pizzeria.service;

import ru.forinnyy.pizzeria.api.repository.IRepository;
import ru.forinnyy.pizzeria.model.AbstractModel;

import java.util.List;

public abstract class AbstractService<M extends AbstractModel, R extends IRepository<M>>
    implements IRepository<M> {

    protected final R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public M add(M model) {
        return repository.add(model);
    }

    @Override
    public List<M> list() {
        return repository.list();
    }

}
