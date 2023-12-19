package org.example.builder;

public class AuctionItem {
    private String itemName;
    private String description;
    private double startingPrice;
    private int auctionDuration;
    private String sellerName;

    private AuctionItem(Builder builder) {
        this.itemName = builder.itemName;
        this.description = builder.description;
        this.startingPrice = builder.startingPrice;
        this.auctionDuration = builder.auctionDuration;
        this.sellerName = builder.sellerName;
    }

    @Override
    public String toString() {
        return "AuctionItem{" +
                "itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", startingPrice=" + startingPrice +
                ", auctionDuration=" + auctionDuration +
                ", sellerName='" + sellerName + '\'' +
                '}';
    }

    public static class Builder {
        private String itemName;
        private String description;
        private double startingPrice;
        private int auctionDuration;
        private String sellerName;

        public Builder(String itemName, double startingPrice) {
            this.itemName = itemName;
            this.startingPrice = startingPrice;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder auctionDuration(int auctionDuration) {
            this.auctionDuration = auctionDuration;
            return this;
        }

        public Builder sellerName(String sellerName) {
            this.sellerName = sellerName;
            return this;
        }

        public AuctionItem build() {
            return new AuctionItem(this);
        }
    }
}

