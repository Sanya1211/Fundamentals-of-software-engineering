package org.example.module;

import java.util.HashMap;
import java.util.Map;


class CoffeeShop {
    private Map<String, Coffee> menu = new HashMap<>();

    public void addToMenu(String name, Coffee coffee) {
        menu.put(name, coffee);
    }

    public Coffee orderCoffee(String name) {
        Coffee coffee = menu.get(name);
        if (coffee != null) {
            return coffee.clone();
        } else {
            System.out.println("Coffee not found on the menu: " + name);
            return null;
        }
    }
}

abstract class Coffee implements Cloneable {
    private String name;

    public Coffee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Coffee clone();
}

class Americano extends Coffee {
    public Americano() {
        super("Americano");
    }

    @Override
    public Coffee clone() {
        return new Americano();
    }
}

class Espresso extends Coffee {
    public Espresso() {
        super("Espresso");
    }

    @Override
    public Coffee clone() {
        return new Espresso();
    }
}

public class Main {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();

        coffeeShop.addToMenu("Americano", new Americano());
        coffeeShop.addToMenu("Espresso", new Espresso());

        Coffee americano = coffeeShop.orderCoffee("Americano");
        Coffee espresso = coffeeShop.orderCoffee("Espresso");

        System.out.println("Ordered: " + americano.getName());
        System.out.println("Ordered: " + espresso.getName());
    }
}

