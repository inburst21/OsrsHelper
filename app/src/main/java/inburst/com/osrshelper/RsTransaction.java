package inburst.com.osrshelper;

@SuppressWarnings("all")
public class RsTransaction {

    private final long ts;

    private final int buyingPrice;

    private final int buyingCompleted;

    private final int sellingPrice;

    private final int sellingCompleted;

    private final int overallPrice;

    private final int overallCompleted;

    public RsTransaction(long ts, int buyingPrice, int buyingCompleted, int sellingPrice,
                         int sellingCompleted, int overallPrice, int overallCompleted) {
        this.ts = ts;
        this.buyingPrice = buyingPrice;
        this.buyingCompleted = buyingCompleted;
        this.sellingPrice = sellingPrice;
        this.sellingCompleted = sellingCompleted;
        this.overallPrice = overallPrice;
        this.overallCompleted = overallCompleted;
    }

    public long getTs() {
        return ts;
    }

    public int getBuyingPrice() {
        return buyingPrice;
    }

    public int getBuyingCompleted() {
        return buyingCompleted;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public int getSellingCompleted() {
        return sellingCompleted;
    }

    public int getOverallPrice() {
        return overallPrice;
    }

    public int getOverallCompleted() {
        return overallCompleted;
    }
}
