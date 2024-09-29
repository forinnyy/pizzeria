package ru.forinnyy.pizzeria.enumerated;

public enum ProductType {

    PIZZA("Пицца"),
    DRINK("Напиток"),
    SNACK("Закуска");

    private final String displayName;

    ProductType(String displayName) {
        this.displayName = displayName;
    }

}
