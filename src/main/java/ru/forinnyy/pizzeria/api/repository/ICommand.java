package ru.forinnyy.pizzeria.api.repository;

public interface ICommand {

    String getName();

    void execute();

}
