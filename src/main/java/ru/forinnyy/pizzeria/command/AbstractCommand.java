package ru.forinnyy.pizzeria.command;

import lombok.Setter;
import ru.forinnyy.pizzeria.api.repository.ICommand;
import ru.forinnyy.pizzeria.api.service.IServiceLocator;

@Setter
public abstract class AbstractCommand implements ICommand {

    protected IServiceLocator serviceLocator;

}
