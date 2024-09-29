package ru.forinnyy.pizzeria.service;

import ru.forinnyy.pizzeria.api.repository.ICommandRepository;
import ru.forinnyy.pizzeria.api.service.ICommandService;
import ru.forinnyy.pizzeria.command.AbstractCommand;

import java.util.Collection;

public final class CommandService implements ICommandService {

    private final ICommandRepository commandRepository;

    public CommandService(ICommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }


    @Override
    public void add(AbstractCommand command) {
        commandRepository.add(command);
    }

    @Override
    public AbstractCommand getCommandByName(String name) {
        return commandRepository.getCommandByName(name);
    }

    @Override
    public Collection<AbstractCommand> getTerminalCommands() {
        return commandRepository.getTerminalCommands();
    }

}
