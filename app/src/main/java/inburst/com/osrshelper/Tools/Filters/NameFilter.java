package inburst.com.osrshelper.Tools.Filters;

import inburst.com.osrshelper.Entity.EntityItem;

/** lennyhicks 9/7/18 */
public class NameFilter extends BaseFilter<EntityItem> {
  private final String filter;

  public NameFilter(String filter) {
    this.filter = filter;
  }

  @Override
  public boolean filter(EntityItem object) {
    return object.getName().toLowerCase().contains(filter);
  }
}
