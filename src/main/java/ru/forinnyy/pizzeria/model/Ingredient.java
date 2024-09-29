package ru.forinnyy.pizzeria.model;

import lombok.Getter;

@Getter
public final class Ingredient extends AbstractModel {

    private String name;

    public Ingredient(String name) {
        this.name = name;
    }

}
