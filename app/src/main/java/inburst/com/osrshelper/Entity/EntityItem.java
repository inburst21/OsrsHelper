package inburst.com.osrshelper.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/** lennyhicks 9/4/18 */
@Entity
public class EntityItem {

  @PrimaryKey
  private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("members")
    private boolean members;

    @SerializedName("sp")
    private  int sp;

    @SerializedName("buy_average")
    private int buyAverage;

    @SerializedName("buy_quantity")
    private int buyQuantity;

    @SerializedName("sell_average")
    private int sellAverage;

    @SerializedName("sell_quantity")
    private int sellQuantity;

    @SerializedName("overall_average")
    private int overallAverage;

    @SerializedName("overall_quantity")
    private int overallQuantity;

  public EntityItem() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMembers() {
        return members;
    }

    public void setMembers(boolean members) {
        this.members = members;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getBuyAverage() {
        return buyAverage;
    }

    public void setBuyAverage(int buyAverage) {
        this.buyAverage = buyAverage;
    }

    public int getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(int buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public int getSellAverage() {
        return sellAverage;
    }

    public void setSellAverage(int sellAverage) {
        this.sellAverage = sellAverage;
    }

    public int getSellQuantity() {
        return sellQuantity;
    }

    public void setSellQuantity(int sellQuantity) {
        this.sellQuantity = sellQuantity;
    }

    public int getOverallAverage() {
        return overallAverage;
    }

    public void setOverallAverage(int overallAverage) {
        this.overallAverage = overallAverage;
    }

    public int getOverallQuantity() {
        return overallQuantity;
    }

    public void setOverallQuantity(int overallQuantity) {
        this.overallQuantity = overallQuantity;
    }
}
