package inburst.com.osrshelper.Tools;

import java.util.Comparator;

import inburst.com.osrshelper.Tools.Comparators.HighAlchComparator;
import inburst.com.osrshelper.Tools.Comparators.MostTradedComparator;
import inburst.com.osrshelper.Tools.Comparators.NameComparator;
import inburst.com.osrshelper.Tools.Comparators.ProfitComparator;

/**
 * lennyhicks
 * 9/7/18
 */
public enum  SortType {

    PROFIT_MARGIN("Profit Margin", new ProfitComparator()),
    HIGH_ALCH("High Alch Profit", new HighAlchComparator()),
    ALPHA("Alpha", new NameComparator()),
    MOST_TRADED("Quantity Traded", new MostTradedComparator());


    private final String name;
    private final Comparator comparator;

    SortType(String name, Comparator comparator){
        this.name = name;
        this.comparator = comparator;
    }

    public Comparator getComparator() {
        return comparator;
    }

    @Override public String toString(){
        return name;
    }
}
