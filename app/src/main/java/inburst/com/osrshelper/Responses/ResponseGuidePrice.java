package inburst.com.osrshelper.Responses;

@SuppressWarnings("all")
public class ResponseGuidePrice {
    private final int overall;

    private final int buying;

    private final int buyingQuantity;

    private final int selling;

    private final int sellingQuantity;

    public ResponseGuidePrice(int overall, int buying, int buyingQuantity, int selling,
                              int sellingQuantity) {
        this.overall = overall;
        this.buying = buying;
        this.buyingQuantity = buyingQuantity;
        this.selling = selling;
        this.sellingQuantity = sellingQuantity;
    }

    public int getOverall() {
        return overall;
    }

    public int getBuying() {
        return buying;
    }

    public int getBuyingQuantity() {
        return buyingQuantity;
    }

    public int getSelling() {
        return selling;
    }

    @Override
    public String toString() {
        return "Guide {" +
                "overall=" + overall +
                ", buying=" + buying +
                ", buyingQuantity=" + buyingQuantity +
                ", selling=" + selling +
                ", sellingQuantity=" + sellingQuantity +
                '}';
    }

    public int getSellingQuantity() {
        return sellingQuantity;
    }
}
