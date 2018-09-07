package inburst.com.osrshelper.Responses;

import com.google.gson.JsonObject;

import inburst.com.osrshelper.Tools.Mappers.SummaryMapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * lennyhicks
 * 9/6/18
 */
public class CallbackSummary implements Callback<JsonObject> {

    private CallbackListener listener;
    private SummaryMapper summaryMapper = new SummaryMapper();


    public CallbackSummary(CallbackListener callbackListener) {
        this.listener = callbackListener;
    }

    @Override
    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
        listener.onSuccess(summaryMapper.from(response.body()).getItems());
    }

    @Override
    public void onFailure(Call<JsonObject> call, Throwable t) {
        listener.onError(t.getLocalizedMessage());
    }
}
