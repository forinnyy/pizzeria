package ru.forinnyy.pizzeria.model;

import lombok.Getter;
import ru.forinnyy.pizzeria.command.AbstractCommand;

@Getter
public final class User extends AbstractModel {

    private String login;

}
