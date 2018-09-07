package inburst.com.osrshelper.Views.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import inburst.com.osrshelper.Database.DaoItem;
import inburst.com.osrshelper.Database.ItemRepo;
import inburst.com.osrshelper.Entity.EntityItem;
import inburst.com.osrshelper.Entity.EntityTransaction;
import inburst.com.osrshelper.Networking.RetrofitClientInstance;
import inburst.com.osrshelper.Responses.CallbackListener;
import inburst.com.osrshelper.Services.GeTrackerService;
import inburst.com.osrshelper.Tools.Filters.BaseFilter;
import inburst.com.osrshelper.Tools.Mappers.ListItemMapper;
import inburst.com.osrshelper.Tools.Mappers.ListTransactionMapper;
import inburst.com.osrshelper.Tools.QueryTypes;
import inburst.com.osrshelper.Tools.SortType;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/** lennyhicks 9/6/18 */
public class MainPresenter implements CallbackListener<List<EntityItem>> {

  private ItemRepo itemRepo;
  private GeTrackerService geTrackerService;
  private MainView mainView;
  private ListItemMapper listItemMapper;
  private ListTransactionMapper listTransactionMapper = new ListTransactionMapper();
  private List<EntityItem> list = new ArrayList<>();
  private List<EntityItem> filteredList = new ArrayList<>();
  private SortType sortType = SortType.PROFIT_MARGIN;
  private BaseFilter filter;
    private int id;
    private QueryTypes.Interval interval = QueryTypes.Interval.THIRTY_MIN;
    private QueryTypes.PreDate preDate = QueryTypes.PreDate.SIX_HOUR;

    public MainPresenter(DaoItem daoRsItem, MainView mainView) {
    this.mainView = mainView;
    this.itemRepo = new ItemRepo(daoRsItem);
    this.itemRepo.getItems(this);
    this.geTrackerService =
        RetrofitClientInstance.getRetrofitInstance().create(GeTrackerService.class);

        this.listItemMapper = new ListItemMapper(sortType);
  }

  public void showItem(int id) {
      this.id = id;
      queryTransaction(QueryTypes.Interval.THIRTY_MIN);
      mainView.setSearchVisibility(false);
  }

  public void showItemList() {
    this.mainView.setSearchVisibility(true);
    this.mainView.showList(listItemMapper.from(filteredList));
  }

  public void sort(SortType sortType) {
    this.sortType = sortType;
    this.listItemMapper = new ListItemMapper(sortType);
    this.filter(filter);
  }

  public void filter(BaseFilter filter) {
    this.filter = filter;
    filteredList = new ArrayList<>();
    for (EntityItem entityItem : list) {
      if (filter == null || filter.filter(entityItem)) {
        filteredList.add(entityItem);
      }
    }
    if (sortType != null) {
      Collections.sort(filteredList, sortType.getComparator());
    }
    this.mainView.showList(this.listItemMapper.from(filteredList));
  }

    public void queryTransaction(QueryTypes.Interval interval) {
        this.interval = interval;

    geTrackerService
        .getTransactionList(
            new Date().getTime() - preDate.getInterval(), interval.getInterval(), id)
        .enqueue(
            new Callback<List<EntityTransaction>>() {
              @Override
              public void onResponse(
                  Call<List<EntityTransaction>> call, Response<List<EntityTransaction>> response) {
                if (response.isSuccessful()) {
                  mainView.showList(listTransactionMapper.from(response.body()));
                } else {
                    try {
                        mainView.showError(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
              }

              @Override
              public void onFailure(Call<List<EntityTransaction>> call, Throwable t) {
                mainView.showError(t.getLocalizedMessage());
              }
            });
    }

    public void predate(QueryTypes.PreDate preDate) {
        this.preDate = preDate;
        queryTransaction(interval);
    }

    @Override
    public void onSuccess(List<EntityItem> list) {
        this.list = list;
        itemRepo.storeItemsInDB(list);
        filter(null);
    }

    @Override
    public void onError(String error) {
        mainView.showError(error);
    }
}
