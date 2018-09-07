package inburst.com.osrshelper.Tools.Mappers;

import java.util.ArrayList;
import java.util.List;

import inburst.com.osrshelper.Entity.EntityItem;
import inburst.com.osrshelper.Tools.SortType;
import inburst.com.osrshelper.ViewHolder.Model.ItemModel;

/**
 * lennyhicks
 * 9/6/18
 */
public class ListItemMapper extends BaseMapper<List<EntityItem>, List<ItemModel>> {

    private ItemMapper itemMapper;

    public ListItemMapper(SortType sortType){
        this.itemMapper = new ItemMapper(sortType);
    }

    @Override
    public List<ItemModel> from(List<EntityItem> entityItems) {
        ArrayList<ItemModel> items = new ArrayList<>();
        for(EntityItem entityItem : entityItems) {
            items.add(itemMapper.from(entityItem));
        }
        return items;
    }
}
