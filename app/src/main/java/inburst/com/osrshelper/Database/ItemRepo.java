package inburst.com.osrshelper.Database;

import java.util.List;

import inburst.com.osrshelper.Entity.EntityItem;
import inburst.com.osrshelper.Networking.RetrofitSummary;
import inburst.com.osrshelper.Responses.CallbackListener;
import inburst.com.osrshelper.Responses.CallbackSummary;
import inburst.com.osrshelper.Services.SummaryService;
import io.reactivex.Flowable;

/** lennyhicks 9/6/18 */
public class ItemRepo {
  private final SummaryService summaryService;
  private final DaoItem daoRsItem;

  public ItemRepo(DaoItem daoRsItem) {
    this.summaryService = RetrofitSummary.getRetrofitInstance().create(SummaryService.class);
    this.daoRsItem = daoRsItem;
  }

  public void getItems(CallbackListener callbackListener) {
    summaryService.getGeSummary().enqueue(new CallbackSummary(callbackListener));
  }

  public Flowable<EntityItem> getItemsFromDB() {
    return daoRsItem.getItems();
  }

  public void storeItemsInDB(List<EntityItem> items) {
    daoRsItem.insertListItems(items);
  }

}
