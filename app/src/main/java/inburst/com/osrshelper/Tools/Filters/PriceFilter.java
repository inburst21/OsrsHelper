package inburst.com.osrshelper.Tools.Filters;

import inburst.com.osrshelper.Entity.EntityItem;

/**
 * lennyhicks
 * 9/7/18
 */
public class PriceFilter extends BaseFilter<EntityItem> {
    private final int amount;

    public PriceFilter(int amount) {
        this.amount = amount;
    }
    @Override
    public boolean filter(EntityItem object) {
        return object.getSellAverage() < amount;
    }
}
