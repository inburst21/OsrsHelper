package inburst.com.osrshelper.Services;

import java.util.List;

import inburst.com.osrshelper.Entity.EntityTransaction;
import inburst.com.osrshelper.Responses.ResponseGuidePrice;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * lennyhicks
 * 9/4/18
 */

public interface GeTrackerService {

    String guidePrice = "guidePrice";

    @GET("?a=graph")
    Call<List<EntityTransaction>> getTransactionList(@Query("start") long predate, @Query("g") int interval, @Query("i") int id);

    @GET("?")
    Call<ResponseGuidePrice> getGuidePrice(@Query("a") String type, @Query("i") int id);

}
