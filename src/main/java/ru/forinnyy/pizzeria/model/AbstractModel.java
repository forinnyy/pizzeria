package ru.forinnyy.pizzeria.model;

import java.util.UUID;

public abstract class AbstractModel {

    private final String id = UUID.randomUUID().toString();

}
