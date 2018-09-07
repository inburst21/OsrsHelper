package inburst.com.osrshelper.Tools.Comparators;

import java.util.Comparator;

import inburst.com.osrshelper.Entity.EntityItem;
import inburst.com.osrshelper.Tools.Profit;

/**
 * lennyhicks
 * 9/6/18
 */
public class HighAlchComparator implements Comparator<EntityItem> {
    @Override
    public int compare(EntityItem entityItem, EntityItem entityItem2) {
        return Profit.getHighAlchProfit(entityItem2) - Profit.getHighAlchProfit(entityItem);
    }
}
