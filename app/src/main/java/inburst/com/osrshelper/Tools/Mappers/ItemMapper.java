package inburst.com.osrshelper.Tools.Mappers;

import inburst.com.osrshelper.Entity.EntityItem;
import inburst.com.osrshelper.Tools.Formatter;
import inburst.com.osrshelper.Tools.Profit;
import inburst.com.osrshelper.Tools.SortType;
import inburst.com.osrshelper.ViewHolder.Model.ItemModel;

/** lennyhicks 9/6/18 */
public class ItemMapper extends BaseMapper<EntityItem, ItemModel> {

  private final SortType sortType;

  public ItemMapper(SortType sortType) {
    this.sortType = sortType;
  }

  @Override
  public ItemModel from(EntityItem entity) {
    ItemModel itemModel = new ItemModel();
    itemModel.setName(entity.getName());
    itemModel.setBuyAverage(Formatter.numberToString(entity.getBuyAverage()));
    itemModel.setSellAverage(Formatter.numberToString(entity.getSellAverage()));
    switch (sortType) {
      case HIGH_ALCH:
          itemModel.setLastField(sortType.toString());
        itemModel.setProfitMargin(Formatter.numberToString(Profit.getHighAlchProfit(entity)));
        break;
      case MOST_TRADED:
          itemModel.setLastField(sortType.toString());
        itemModel.setProfitMargin(Formatter.numberToString(entity.getOverallQuantity()));
        break;

      default:
          itemModel.setLastField("Profit");
        itemModel.setProfitMargin(Formatter.numberToString(Profit.getProfitMargin(entity)));
    }
    itemModel.setItemId(entity.getId());
    return itemModel;
  }
}
