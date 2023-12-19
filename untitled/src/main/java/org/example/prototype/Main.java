package org.example.prototype;

class AuctionItem implements Cloneable {
    private String itemName;
    private double initialPrice;

    public AuctionItem(String itemName, double initialPrice) {
        this.itemName = itemName;
        this.initialPrice = initialPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    @Override
    public AuctionItem clone() {
        try {
            return (AuctionItem) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class OnlineAuction {
    private String auctionName;
    private AuctionItem auctionItem;

    public OnlineAuction(String auctionName, AuctionItem auctionItem) {
        this.auctionName = auctionName;
        this.auctionItem = auctionItem;
    }

    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionItem(AuctionItem auctionItem) {
        this.auctionItem = auctionItem;
    }

    public AuctionItem cloneAuctionItem() {
        return auctionItem.clone();
    }
}

public class Main {
    public static void main(String[] args) {
        AuctionItem originalItem = new AuctionItem("Painting", 500.0);

        OnlineAuction originalAuction = new OnlineAuction("Art Auction", originalItem);

        AuctionItem clonedItem = originalAuction.cloneAuctionItem();
        OnlineAuction clonedAuction = new OnlineAuction("Copy of Art Auction", clonedItem);

        System.out.println("Original Auction: " + originalAuction.getAuctionName() +
                ", Item: " + originalAuction.cloneAuctionItem().getItemName() +
                ", Initial Price: " + originalAuction.cloneAuctionItem().getInitialPrice());

        System.out.println("Cloned Auction: " + clonedAuction.getAuctionName() +
                ", Item: " + clonedAuction.cloneAuctionItem().getItemName() +
                ", Initial Price: " + clonedAuction.cloneAuctionItem().getInitialPrice());
    }
}
