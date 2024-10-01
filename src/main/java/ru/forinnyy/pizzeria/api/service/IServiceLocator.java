package ru.forinnyy.pizzeria.api.service;

public interface IServiceLocator {

    ICommandService getCommandService();

    IProductService getProductService();

    IOrderService getOrderService();

}
