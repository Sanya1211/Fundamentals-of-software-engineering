package org.example.singletone;

public class OnlineAuction {
    private static OnlineAuction instance;

    private OnlineAuction() {

    }

    public static OnlineAuction getInstance() {
        if (instance == null) {
            instance = new OnlineAuction();
        }
        return instance;
    }

    public void startAuction() {
        System.out.println("Auction started!");
    }

    public void endAuction() {
        System.out.println("Auction ended!");
    }


    public static void main(String[] args) {
        OnlineAuction auction1 = OnlineAuction.getInstance();
        auction1.startAuction();

        OnlineAuction auction2 = OnlineAuction.getInstance();
        auction2.endAuction();

        System.out.println(auction2.equals(auction1));
        System.out.println(auction2 == auction1);
    }
}
