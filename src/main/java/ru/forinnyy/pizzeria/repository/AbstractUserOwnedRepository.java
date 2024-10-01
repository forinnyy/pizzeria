package ru.forinnyy.pizzeria.repository;

import ru.forinnyy.pizzeria.api.repository.IUserOwnedRepository;
import ru.forinnyy.pizzeria.model.AbstractUserOwnedModel;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractUserOwnedRepository<M extends AbstractUserOwnedModel>
        extends AbstractRepository<M>
        implements IUserOwnedRepository<M> {

    @Override
    public void clear(String userId) {
        // change
    }

    @Override
    public List<M> list(String userId) {
        return null; // change
    }

    @Override
    public M add(String userId, M model) {
        return null; // change
    }

}
