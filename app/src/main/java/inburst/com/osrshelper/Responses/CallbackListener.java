package inburst.com.osrshelper.Responses;

/**
 * lennyhicks
 * 9/6/18
 */
public interface CallbackListener<T> {
    void onSuccess(T list);
    void onError(String error);
}
