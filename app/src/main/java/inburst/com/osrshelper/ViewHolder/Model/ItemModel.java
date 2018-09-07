package inburst.com.osrshelper.ViewHolder.Model;

import inburst.com.osrshelper.ViewHolder.Base.BaseModel;
import inburst.com.osrshelper.Tools.ViewTypes;

/**
 * lennyhicks
 * 9/6/18
 */
public class ItemModel implements BaseModel {

    private String name;
    private String buyAverage;
    private String sellAverage;
    private String profitMargin;
    private int itemId;
    private String lastField;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuyAverage() {
        return buyAverage;
    }

    public void setBuyAverage(String buyAverage) {
        this.buyAverage = buyAverage;
    }

    public String getSellAverage() {
        return sellAverage;
    }

    public void setSellAverage(String sellAverage) {
        this.sellAverage = sellAverage;
    }

    public String getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(String profitMargin) {
        this.profitMargin = profitMargin;
    }

    @Override
    public int getViewType() {
        return ViewTypes.ITEM;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setLastField(String lastField) {
        this.lastField = lastField;
    }

    public String getLastField() {
        return lastField;
    }
}
