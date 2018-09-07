package inburst.com.osrshelper.Responses;

import java.util.List;

import inburst.com.osrshelper.Entity.EntityItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/** lennyhicks 9/7/18 */
public class CallbackItemList implements Callback<List<EntityItem>> {

  private final CallbackListener<List<EntityItem>> listCallbackListener;

  public CallbackItemList(CallbackListener<List<EntityItem>> listCallbackListener) {
    this.listCallbackListener = listCallbackListener;
  }

  @Override
  public void onResponse(
      Call<List<EntityItem>> call, Response<List<EntityItem>> response) {
      listCallbackListener.onSuccess(response.body());
  }

  @Override
  public void onFailure(Call<List<EntityItem>> call, Throwable t) {
      listCallbackListener.onError(t.getLocalizedMessage());
  }
}
