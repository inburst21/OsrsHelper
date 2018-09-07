package inburst.com.osrshelper.ViewHolder.Base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * lennyhicks
 * 9/6/18
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(T entity);

}
