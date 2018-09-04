package inburst.com.osrshelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * lennyhicks
 * 9/4/18
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<RsTransaction> dataList;
    private Context context;

    public CustomAdapter(Context context,List<RsTransaction> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtName;
        TextView txtBuyPrice;
        TextView txtSellPrice;
//        private ImageView coverImage;

        CustomViewHolder(final View itemView) {
            super(itemView);
            mView = itemView;

            this.txtName = itemView.findViewById(R.id.item_name);
            this.txtBuyPrice = itemView.findViewById(R.id.buy_price);
            this.txtSellPrice = itemView.findViewById(R.id.sell_avg);

//            coverImage = mView.findViewById(R.id.coverImage);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_transaction, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
//        holder.txtName.setText(dataList.get(position).getOverallCompleted());
        holder.txtBuyPrice.setText(dataList.get(position).getBuyingPrice());
//        holder.txtSellPrice.setText(dataList.get(position).getSellingPrice());
        Log.d("Price ", dataList.get(position).getBuyingPrice() + "");

//        Picasso.Builder builder = new Picasso.Builder(context);
//        builder.downloader(new OkHttp3Downloader(context));
//        builder.build().load(dataList.get(position).getThumbnailUrl())
//                .placeholder((R.drawable.ic_launcher_background))
//                .error(R.drawable.ic_launcher_background)
//                .into(holder.coverImage);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}