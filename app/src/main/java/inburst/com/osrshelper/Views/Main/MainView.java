package inburst.com.osrshelper.Views.Main;

import java.util.List;

import inburst.com.osrshelper.ViewHolder.Base.BaseModel;

/**
 * lennyhicks
 * 9/6/18
 */
public interface MainView {
    void showList(List<? extends BaseModel> models);
    void showError(String message);
    void setSearchVisibility(boolean visibility);
}
