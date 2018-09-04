package inburst.com.osrshelper;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  private RecyclerView recyclerView;
  private CustomAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
      ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 225);
    RetrofitClientInstance.getRetrofitInstance().create(GeTrackerService.class);

    GeTrackerService service =
        RetrofitClientInstance.getRetrofitInstance().create(GeTrackerService.class);

    service
        .getTransactionList()
        .enqueue(
            new Callback<List<RsTransaction>>() {
              @Override
              public void onResponse(Call<List<RsTransaction>> call, Response<List<RsTransaction>> response) {
                Log.d("Response", response.message() + " : " + response.body());
                if (response.isSuccessful()) {
                  generateDataList(response.body());
                } else {
                    try {
                        Log.d("Error", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
              }

              @Override
              public void onFailure(Call<List<RsTransaction>> call, Throwable t) {
                Toast.makeText(
                        MainActivity.this,
                        "Something went wrong...Please try later!",
                        Toast.LENGTH_SHORT)
                    .show();
              }
            });
  }

  private void generateDataList(List<RsTransaction> body) {
    recyclerView = findViewById(R.id.custom_recycler);
    adapter = new CustomAdapter(this, body);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);
  }
}
