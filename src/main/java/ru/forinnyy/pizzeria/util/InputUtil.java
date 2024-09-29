package ru.forinnyy.pizzeria.util;

import java.util.Scanner;

public interface InputUtil {

    Scanner SCANNER = new Scanner(System.in);

    static String nextLine() {
        return SCANNER.nextLine();
    }

    static Integer nextNumber() {
        final String value = nextLine();
        try {
            return Integer.parseInt(value);
        } catch (final RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
