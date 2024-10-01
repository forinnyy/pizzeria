package ru.forinnyy.pizzeria.api.repository;

import ru.forinnyy.pizzeria.model.AbstractUserOwnedModel;

import java.util.List;

public interface IUserOwnedRepository<M extends AbstractUserOwnedModel> extends IRepository<M> {

    M add(String userId, M model);

    List<M> list(String userId);

    void clear(String userId);

}
