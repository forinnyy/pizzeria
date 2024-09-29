package ru.forinnyy.pizzeria.api.repository;

import ru.forinnyy.pizzeria.command.AbstractCommand;

import java.util.Collection;

public interface ICommandRepository {

    void add(AbstractCommand command);

    AbstractCommand getCommandByName(String name);

    Collection<AbstractCommand> getTerminalCommands();

}
