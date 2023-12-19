package org.example.builder;

public class Main {
    public static void main(String[] args) {
        AuctionItem item = new AuctionItem.Builder("Картина", 100.0)
                .description("Прекрасна картина митця")
                .auctionDuration(7)
                .sellerName("John Doe")
                .build();
        System.out.println(item);
    }
}
