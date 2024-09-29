package ru.forinnyy.pizzeria.component;

import lombok.Getter;
import lombok.SneakyThrows;
import org.reflections.Reflections;
import ru.forinnyy.pizzeria.api.repository.ICommandRepository;
import ru.forinnyy.pizzeria.api.service.ICommandService;
import ru.forinnyy.pizzeria.api.service.IServiceLocator;
import ru.forinnyy.pizzeria.command.AbstractCommand;
import ru.forinnyy.pizzeria.repository.CommandRepository;
import ru.forinnyy.pizzeria.service.CommandService;
import ru.forinnyy.pizzeria.util.InputUtil;

import java.lang.reflect.Modifier;
import java.util.Set;

public final class Bootstrap implements IServiceLocator {

    private static final String PACKAGE_COMMANDS = "ru.forinnyy.pizzeria";

    private final ICommandRepository commandRepository = new CommandRepository();

    @Getter
    private final ICommandService commandService = new CommandService(commandRepository);


    {
        final Reflections reflections = new Reflections(PACKAGE_COMMANDS);
        final Set<Class<? extends AbstractCommand>> classes =
                reflections.getSubTypesOf(AbstractCommand.class);
        for (final Class<? extends AbstractCommand> clazz : classes) registry(clazz);
    }

    @SneakyThrows
    private void registry(final Class<? extends AbstractCommand> clazz) {
        if (Modifier.isAbstract(clazz.getModifiers())) return;
        if (!AbstractCommand.class.isAssignableFrom(clazz)) return;
        final AbstractCommand command = clazz.newInstance();
        registry(command);
    }

    private void registry(final AbstractCommand command) {
        command.setServiceLocator(this);
        commandService.add(command);
    }

    public void processCommand(final String command) {
        final AbstractCommand abstractCommand = commandService.getCommandByName(command);
        abstractCommand.execute();
    }

    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            try {
                System.out.println("ENTER COMMAND: ");
                final String command = InputUtil.nextLine();
                processCommand(command);
                System.out.println("[SYSTEM] [OK]");
            } catch (RuntimeException e) {
                System.err.println("[SYSTEM] [ERROR] " + e);
            }
        }

    }

}
