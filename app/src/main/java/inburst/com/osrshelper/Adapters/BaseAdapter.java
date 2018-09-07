package inburst.com.osrshelper.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import inburst.com.osrshelper.R;
import inburst.com.osrshelper.Tools.ViewTypes;
import inburst.com.osrshelper.ViewHolder.Base.BaseModel;
import inburst.com.osrshelper.ViewHolder.Base.BaseViewHolder;
import inburst.com.osrshelper.ViewHolder.ItemViewHolder;
import inburst.com.osrshelper.ViewHolder.TransactionViewHolder;
import inburst.com.osrshelper.Views.Main.MainListener;

/**
 * lennyhicks
 * 9/4/18
 */
public class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<? extends BaseModel> modelList;
    private LayoutInflater mInflater;
    private MainListener itemClickListener;

    public BaseAdapter(List<BaseModel> modelList, LayoutInflater mInflater, MainListener itemClickListener){
        this.modelList = modelList;
        this.mInflater = mInflater;
        this.itemClickListener = itemClickListener;
    }

    public void updateList(List<? extends BaseModel> modelList) {
        this.modelList = modelList;
        this.notifyDataSetChanged();
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ViewTypes.ITEM : return new ItemViewHolder(mInflater.inflate(R.layout.item_view, parent, false), itemClickListener);
            case ViewTypes.TRANSACTION: return new TransactionViewHolder(mInflater.inflate(R.layout.item_transaction, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final BaseViewHolder holder, final int position) {
        holder.bind(modelList.get(position));

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return modelList.get(position).getViewType();
    }

}