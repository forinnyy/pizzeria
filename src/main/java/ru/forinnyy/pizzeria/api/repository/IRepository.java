package ru.forinnyy.pizzeria.api.repository;

import ru.forinnyy.pizzeria.model.AbstractModel;

import java.util.List;

public interface IRepository<M extends AbstractModel> {

    M add(M model);

    List<M> list();

}
