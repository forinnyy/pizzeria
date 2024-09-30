package ru.forinnyy.pizzeria.api.repository;

import ru.forinnyy.pizzeria.model.AbstractModel;

public interface IRepository<M extends AbstractModel> {

    M add(M model);

    void list();

}
