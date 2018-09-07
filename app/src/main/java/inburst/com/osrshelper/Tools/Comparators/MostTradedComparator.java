package inburst.com.osrshelper.Tools.Comparators;

import java.util.Comparator;

import inburst.com.osrshelper.Entity.EntityItem;

/**
 * lennyhicks
 * 9/7/18
 */
public class MostTradedComparator implements Comparator<EntityItem> {
    @Override
    public int compare(EntityItem entityItem, EntityItem t1) {
        return t1.getOverallQuantity() - entityItem.getOverallQuantity();
    }
}
