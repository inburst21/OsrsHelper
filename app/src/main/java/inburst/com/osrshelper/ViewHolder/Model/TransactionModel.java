package inburst.com.osrshelper.ViewHolder.Model;

import inburst.com.osrshelper.ViewHolder.Base.BaseModel;
import inburst.com.osrshelper.Tools.ViewTypes;

/**
 * lennyhicks
 * 9/6/18
 */
public class TransactionModel implements BaseModel {
    private String transactionTime;
    private String buyQuantity;
    private String sellQuantity;
    private String buyPrice;
    private String sellPrice;

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(String buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public String getSellQuantity() {
        return sellQuantity;
    }

    public void setSellQuantity(String sellQuantity) {
        this.sellQuantity = sellQuantity;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public int getViewType() {
        return ViewTypes.TRANSACTION;
    }
}
