package ru.forinnyy.pizzeria.enumerated;

public enum OrderPickupType {

    TAKEAWAY("Самовывоз"),
    DINEIN("В пиццерии"),
    DELIVERY("Доставка");

    private final String displayName;

    OrderPickupType(String displayName) {
        this.displayName = displayName;
    }

}
