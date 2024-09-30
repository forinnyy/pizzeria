package ru.forinnyy.pizzeria.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class AbstractModel {

    private final String id = UUID.randomUUID().toString();

}
