package inburst.com.osrshelper.Tools.Comparators;

import java.util.Comparator;

import inburst.com.osrshelper.Entity.EntityItem;

/**
 * lennyhicks
 * 9/7/18
 */
public class NameComparator implements Comparator<EntityItem> {
    @Override
    public int compare(EntityItem entityItem, EntityItem entityItem2) {
        return entityItem.getName().compareTo(entityItem2.getName());
    }
}
