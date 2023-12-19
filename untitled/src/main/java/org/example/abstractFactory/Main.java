package org.example.abstractFactory;

interface AuctionItem {
    String getDescription();
}

class ConcreteAuctionItem implements AuctionItem {
    private String description;

    public ConcreteAuctionItem(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

interface AuctionParticipant {
    String getName();
}

class ConcreteAuctionParticipant implements AuctionParticipant {
    private String name;

    public ConcreteAuctionParticipant(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

interface AuctionFactory {
    AuctionItem createAuctionItem(String description);
    AuctionParticipant createAuctionParticipant(String name);
}

class ConcreteAuctionFactory implements AuctionFactory {
    @Override
    public AuctionItem createAuctionItem(String description) {
        return new ConcreteAuctionItem(description);
    }

    @Override
    public AuctionParticipant createAuctionParticipant(String name) {
        return new ConcreteAuctionParticipant(name);
    }
}

public class Main {
    public static void main(String[] args) {
        AuctionFactory auctionFactory = new ConcreteAuctionFactory();

        AuctionItem item = auctionFactory.createAuctionItem("Painting");
        AuctionParticipant participant = auctionFactory.createAuctionParticipant("John Doe");

        System.out.println("Auction Item: " + item.getDescription());
        System.out.println("Auction Participant: " + participant.getName());
    }
}

