package org.example.adapter;

interface OldAuction {
    void placeBid(String bidder, double amount);

    double getCurrentBid();
}

interface NewAuction {
    void makeBid(String bidder, double bidAmount);

    double getCurrentPrice();
}

class AuctionAdapter implements NewAuction {
    private OldAuction oldAuction;

    public AuctionAdapter(OldAuction oldAuction) {
        this.oldAuction = oldAuction;
    }

    @Override
    public void makeBid(String bidder, double bidAmount) {
        oldAuction.placeBid(bidder, bidAmount);
    }

    @Override
    public double getCurrentPrice() {
        return oldAuction.getCurrentBid();
    }
}

public class Main {
    public static void main(String[] args) {
        OldAuction oldAuction = new OldAuctionImpl();

        NewAuction newAuctionAdapter = new AuctionAdapter(oldAuction);

        newAuctionAdapter.makeBid("User1", 100.0);
        System.out.println("Current Price: " + newAuctionAdapter.getCurrentPrice());
    }
}

class OldAuctionImpl implements OldAuction {
    private String currentBidder;
    private double currentBid;

    @Override
    public void placeBid(String bidder, double amount) {
        if (amount > currentBid) {
            currentBidder = bidder;
            currentBid = amount;
        }
    }

    @Override
    public double getCurrentBid() {
        return currentBid;
    }
}
