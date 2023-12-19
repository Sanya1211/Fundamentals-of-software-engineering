package org.example.factoryMethode;

import java.util.Scanner;

interface Item {
    void displayInfo();
}

class Painting implements Item {
    @Override
    public void displayInfo() {
        System.out.println("Painting for auction");
    }
}

class Sneakers implements Item {
    @Override
    public void displayInfo() {
        System.out.println("Sneakers for auction");
    }
}

interface ItemFactory {
    Item createItem();
}

class PaintingFactory implements ItemFactory {
    @Override
    public Item createItem() {
        return new Painting();
    }
}

class SneakersFactory implements ItemFactory {
    @Override
    public Item createItem() {
        return new Sneakers();
    }
}

public class Main {
    public static void main(String[] args) {
        String itemType = getUserInput();

        ItemFactory itemFactory = createItemFactory(itemType);

        Item item = itemFactory.createItem();

        item.displayInfo();
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item type (e.g., 'Painting' or 'Sneakers'):");
        return scanner.nextLine().toLowerCase();
    }

    private static ItemFactory createItemFactory(String itemType) {
        if ("painting".equals(itemType)) {
            return new PaintingFactory();
        } else if ("sneakers".equals(itemType)) {
            return new SneakersFactory();
        } else {
            System.out.println("Invalid item type");
            System.exit(0);
            return null;
        }
    }
}

