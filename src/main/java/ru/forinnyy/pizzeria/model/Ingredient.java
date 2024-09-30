package ru.forinnyy.pizzeria.model;

import lombok.Getter;

@Getter
public final class Ingredient extends AbstractModel {

    private final String name;

    public Ingredient(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
