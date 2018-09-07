package inburst.com.osrshelper.Services;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * lennyhicks
 * 9/4/18
 */
public interface SummaryService {
    @GET("summary.json")
    Call<JsonObject> getGeSummary();
}
