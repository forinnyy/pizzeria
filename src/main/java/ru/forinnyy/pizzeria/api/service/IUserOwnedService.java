package ru.forinnyy.pizzeria.api.service;

import ru.forinnyy.pizzeria.api.repository.IUserOwnedRepository;
import ru.forinnyy.pizzeria.model.AbstractUserOwnedModel;

public interface IUserOwnedService<M extends AbstractUserOwnedModel> extends IUserOwnedRepository<M> {
}
