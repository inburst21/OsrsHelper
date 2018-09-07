package inburst.com.osrshelper;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import inburst.com.osrshelper.Adapters.BaseAdapter;
import inburst.com.osrshelper.Database.DatabaseItems;
import inburst.com.osrshelper.Tools.FilterType;
import inburst.com.osrshelper.Tools.Filters.NameFilter;
import inburst.com.osrshelper.Tools.QueryTypes;
import inburst.com.osrshelper.Tools.SortType;
import inburst.com.osrshelper.ViewHolder.Base.BaseModel;
import inburst.com.osrshelper.Views.Main.MainListener;
import inburst.com.osrshelper.Views.Main.MainPresenter;
import inburst.com.osrshelper.Views.Main.MainView;

public class MainActivity extends AppCompatActivity implements MainView, MainListener, TextWatcher {

  private BaseAdapter adapter;
  private MainPresenter mainPresenter;

  @BindView(R.id.spinner_sort)
  Spinner sorter;

  @BindView(R.id.spinner_filter)
  Spinner filter;

  @BindView(R.id.custom_recycler)
  RecyclerView recyclerView;

  @BindView(R.id.filter_name)
  EditText nameFilter;

  ArrayAdapter sortAdapter;
  ArrayAdapter filterAdapter;

  ArrayAdapter queryInterval;
  ArrayAdapter predate;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    setupAdapter();
    sortAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, SortType.values());
      queryInterval =
              new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, QueryTypes.Interval.values());

      predate =
              new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, QueryTypes.PreDate.values());

    filterAdapter =
        new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, FilterType.values());

    mainPresenter =
        new MainPresenter(
            Room.databaseBuilder(this, DatabaseItems.class, "itemDB")
                .allowMainThreadQueries()
                .build()
                .daoAccess(),
            this);
    sorter.setAdapter(sortAdapter);
    filter.setAdapter(filterAdapter);

    updateAdapters(true);
    nameFilter.addTextChangedListener(this);
  }

  private void setupAdapter() {
    adapter = new BaseAdapter(new ArrayList<>(), LayoutInflater.from(this), this);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);
  }

  public void showList(List<? extends BaseModel> list) {
    adapter.updateList(list);
  }

  @Override
  public void showError(String message) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show();
  }

  @Override
  public void onItemClick(int id) {
    mainPresenter.showItem(id);
  }

  @Override
  public void onBackPressed() {
    mainPresenter.showItemList();
  }

  @Override
  public void setSearchVisibility(boolean visibility) {
    nameFilter.setVisibility(visibility ? View.VISIBLE : View.GONE);
    updateAdapters(visibility);
  }

  private void updateAdapters(boolean visibility) {
//      Log.d("yes", "yes" + visibility);
      sorter.setAdapter(visibility ? sortAdapter : queryInterval);
      filter.setAdapter(visibility ? filterAdapter : predate);

    if (!visibility) {
//        Log.d("yes", "yes");
      sorter.setOnItemSelectedListener(
          new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

              QueryTypes.Interval interval = (QueryTypes.Interval) parent.getItemAtPosition(position);
              mainPresenter.queryTransaction(interval);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
          });

      filter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

              QueryTypes.PreDate interval = (QueryTypes.PreDate) parent.getItemAtPosition(position);
              mainPresenter.predate(interval);
          }

          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {

          }
      });


      } else {

        sorter.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

                        SortType sortType = (SortType) parent.getItemAtPosition(position);
                        mainPresenter.sort(sortType);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {}
                });


        filter.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                        FilterType filterType = (FilterType) parent.getItemAtPosition(position);
                        mainPresenter.filter(filterType.getFilter());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {}
                });
    }
//    filter.setAdapter(visibility ? View.VISIBLE : View.GONE);
  }

  @Override
  public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

  @Override
  public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    if (charSequence.length() == 0) {
      //            mainPresenter.filter(null);
    } else {
      mainPresenter.filter(new NameFilter(charSequence.toString()));
    }
  }

  @Override
  public void afterTextChanged(Editable editable) {}
}
