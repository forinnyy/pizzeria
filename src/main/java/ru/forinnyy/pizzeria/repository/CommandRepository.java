package ru.forinnyy.pizzeria.repository;

import ru.forinnyy.pizzeria.api.repository.ICommandRepository;
import ru.forinnyy.pizzeria.command.AbstractCommand;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public final class CommandRepository implements ICommandRepository {

    private final Map<String, AbstractCommand> commandsMap = new TreeMap<>();

    @Override
    public void add(AbstractCommand command) {
        if (command == null) return;
        final String name = command.getName();
        if (!name.isEmpty()) commandsMap.put(name, command);
    }

    @Override
    public AbstractCommand getCommandByName(String name) {
        return commandsMap.get(name);
    }

    @Override
    public Collection<AbstractCommand> getTerminalCommands() {
        return commandsMap.values();
    }

}
