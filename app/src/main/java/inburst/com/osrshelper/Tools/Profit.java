package inburst.com.osrshelper.Tools;

import inburst.com.osrshelper.Entity.EntityItem;

/**
 * lennyhicks
 * 9/6/18
 */
public class Profit {
    public static int getProfitMargin(EntityItem entityRsItem) {
        return entityRsItem.getSellAverage() - entityRsItem.getBuyAverage();
    }

    public static int getHighAlchProfit(EntityItem entityItem) {
        return (int)(entityItem.getSp() * .6) - entityItem.getSellAverage() - 220;
    }
}
