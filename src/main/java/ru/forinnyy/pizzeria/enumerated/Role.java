package ru.forinnyy.pizzeria.enumerated;

public enum Role {

    ADMIN("Admin"),
    EMPLOYEE("Employee"),
    CUSTOMER("Customer");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

}
