package inburst.com.osrshelper;

import com.google.gson.annotations.SerializedName;

/** lennyhicks 9/4/18 */
class RsItem {

  @SerializedName("id")
  private final int id;

  @SerializedName("name")
  private final String name;

  @SerializedName("members")
  private final boolean members;

  @SerializedName("sp")
  private final int sp;


  @SerializedName("buy_average")
  private final int buyAverage;

  @SerializedName("buy_quantity")
  private final int buyQuantity;

  @SerializedName("sell_average")
  private final int sellAverage;

  @SerializedName("sell_quantity")
  private final int sellQuantity;

  @SerializedName("overall_average")
  private final int overallAverage;

  @SerializedName("overall_quantity")
  private final int overallQuantity;

  public RsItem(
      int id,
      String name,
      boolean members,
      int sp,
      int buyAverage,
      int buyQuantity,
      int sellAverage,
      int sellQuantity,
      int overallAverage,
      int overallQuantity) {
    this.id = id;
    this.name = name;
    this.members = members;
    this.sp = sp;
    this.buyAverage = buyAverage;
    this.buyQuantity = buyQuantity;
    this.sellAverage = sellAverage;
    this.sellQuantity = sellQuantity;
    this.overallAverage = overallAverage;
    this.overallQuantity = overallQuantity;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public boolean isMembers() {
    return members;
  }

  public int getSp() {
    return sp;
  }

  public int getBuyAverage() {
    return buyAverage;
  }

  public int getBuyQuantity() {
    return buyQuantity;
  }

  public int getSellAverage() {
    return sellAverage;
  }

  public int getSellQuantity() {
    return sellQuantity;
  }

  public int getOverallAverage() {
    return overallAverage;
  }

  public int getOverallQuantity() {
    return overallQuantity;
  }
}
