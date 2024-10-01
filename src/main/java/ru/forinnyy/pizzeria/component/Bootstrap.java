package ru.forinnyy.pizzeria.component;

import lombok.Getter;
import lombok.SneakyThrows;
import org.reflections.Reflections;
import ru.forinnyy.pizzeria.api.repository.ICommandRepository;
import ru.forinnyy.pizzeria.api.repository.IOrderRepository;
import ru.forinnyy.pizzeria.api.repository.IProductRepository;
import ru.forinnyy.pizzeria.api.service.ICommandService;
import ru.forinnyy.pizzeria.api.service.IOrderService;
import ru.forinnyy.pizzeria.api.service.IProductService;
import ru.forinnyy.pizzeria.api.service.IServiceLocator;
import ru.forinnyy.pizzeria.command.AbstractCommand;
import ru.forinnyy.pizzeria.enumerated.OrderPickupType;
import ru.forinnyy.pizzeria.enumerated.ProductType;
import ru.forinnyy.pizzeria.model.Ingredient;
import ru.forinnyy.pizzeria.model.Product;
import ru.forinnyy.pizzeria.repository.CommandRepository;
import ru.forinnyy.pizzeria.repository.OrderRepository;
import ru.forinnyy.pizzeria.repository.ProductRepository;
import ru.forinnyy.pizzeria.service.CommandService;
import ru.forinnyy.pizzeria.service.OrderService;
import ru.forinnyy.pizzeria.service.ProductService;
import ru.forinnyy.pizzeria.util.InputUtil;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Bootstrap implements IServiceLocator {

    private static final String PACKAGE_COMMANDS = "ru.forinnyy.pizzeria";

    private final ICommandRepository commandRepository = new CommandRepository();

    @Getter
    private final ICommandService commandService = new CommandService(commandRepository);

    private final IProductRepository productRepository = new ProductRepository();

    @Getter
    private final IProductService productService = new ProductService(productRepository);

    private final IOrderRepository orderRepository = new OrderRepository();

    @Getter
    private final IOrderService orderService = new OrderService(orderRepository);

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

    void initData() {
        final Ingredient kolbaski = new Ingredient("Kolbaski");
        final Ingredient testo = new Ingredient("Testo");
        final Ingredient cheese = new Ingredient("Cheese");
        final Ingredient water = new Ingredient("Water");
        final Ingredient sugar = new Ingredient("Sugar");
        final Map<Ingredient, Integer> pepeIngredients = new HashMap<>();
        pepeIngredients.put(kolbaski, 100);
        pepeIngredients.put(testo, 500);
        pepeIngredients.put(cheese, 100);
        final Map<Ingredient, Integer> colaIngredients = new HashMap<>();
        colaIngredients.put(water, 500);
        colaIngredients.put(sugar, 50);
        Product pizza = productService.create(ProductType.PIZZA, "PEPERONI", "PIZZA S KOLBASKAMI", pepeIngredients);
        Product drink = productService.create(ProductType.DRINK, "COLA", "TASTY BLACK WATER", colaIngredients);
        orderService.create(pizza.getId(), OrderPickupType.DELIVERY);
        orderService.create(pizza.getId(), OrderPickupType.DELIVERY);
        orderService.create(drink.getId(), OrderPickupType.TAKEAWAY);
    }

    public void run() {
        initData();
        while (!Thread.currentThread().isInterrupted()) {

            try {
                System.out.println("ENTER COMMAND: ");
                final String command = InputUtil.nextLine();
                processCommand(command);
                System.out.println();
                System.out.println("[SYSTEM] [OK]");
            } catch (RuntimeException e) {
                System.err.println("[SYSTEM] [ERROR] " + e);
            }
        }

    }

}
