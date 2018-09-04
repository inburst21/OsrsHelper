package inburst.com.osrshelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * lennyhicks
 * 9/4/18
 */

public interface GeTrackerService {

    @GET("summary.json")
    Call<List<RsItem>> getGeSummary();

    @GET("?a=graph&start=1425921352106&g=180&i=207")
    Call<List<RsTransaction>> getTransactionList();

}
