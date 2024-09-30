package ru.forinnyy.pizzeria.command.order;

public final class OrderCreateCommand extends AbstractOrderCommand {

    @Override
    public String getName() {
        return "order-create";
    }

    @Override
    public void execute() {
        System.out.println("ORDER CREATED");
    }

}
