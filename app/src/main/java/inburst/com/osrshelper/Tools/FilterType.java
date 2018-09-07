package inburst.com.osrshelper.Tools;

import inburst.com.osrshelper.Tools.Filters.BaseFilter;
import inburst.com.osrshelper.Tools.Filters.PriceFilter;

/**
 * lennyhicks
 * 9/7/18
 */
public enum  FilterType {
    NONE("None", null),
    UNDER_10K("Under 10K", new PriceFilter(10000)),
    UNDER_25K("Under 25K", new PriceFilter(25000)),
    UNDER_50K("Under 50K", new PriceFilter(50000)),
    UNDER_100K("Under 100k", new PriceFilter(50000));


    private final String name;
    private final BaseFilter filter;

    FilterType(String name, BaseFilter filter) {
        this.name = name;
        this.filter = filter;
    }

    public BaseFilter getFilter() {
        return filter;
    }

    @Override
    public String toString() {
        return name;
    }
}
