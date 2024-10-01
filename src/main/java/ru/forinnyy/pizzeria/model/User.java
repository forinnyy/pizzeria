package ru.forinnyy.pizzeria.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.forinnyy.pizzeria.command.AbstractCommand;

@Getter
@Setter
@NoArgsConstructor
public final class User extends AbstractModel {

    private String login;

    private String passwordHash;

    private String name;

    private String address;

}
