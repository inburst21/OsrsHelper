package inburst.com.osrshelper.ViewHolder;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import inburst.com.osrshelper.R;
import inburst.com.osrshelper.ViewHolder.Base.BaseViewHolder;
import inburst.com.osrshelper.ViewHolder.Model.ItemModel;
import inburst.com.osrshelper.Views.Main.MainListener;

/**
 * lennyhicks
 * 9/6/18
 */
public class ItemViewHolder extends BaseViewHolder<ItemModel> implements View.OnClickListener {


    @BindView(R.id.text_item_name)
    public TextView txtName;
    @BindView(R.id.text_item_buy_price)
    public TextView txtBuyPrice;
    @BindView(R.id.text_item_sell_price)
    public TextView txtSellPrice;
    @BindView(R.id.text_item_profit)
    public TextView txtProfit;

    @BindView(R.id.text_three)
    public TextView textView;

    private ItemModel item;
    private MainListener onItemClickListener;

    public ItemViewHolder(View itemView, MainListener onItemClickListener) {
        super(itemView);
        this.onItemClickListener = onItemClickListener;
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void bind(ItemModel item) {
        this.item = item;
        txtName.setText(item.getName());
        txtBuyPrice.setText(item.getBuyAverage());
        txtSellPrice.setText(item.getSellAverage());
        txtProfit.setText(item.getProfitMargin());
        textView.setText(item.getLastField());
    }

    @Override
    public void onClick(View view) {
        onItemClickListener.onItemClick(item.getItemId());
    }
}