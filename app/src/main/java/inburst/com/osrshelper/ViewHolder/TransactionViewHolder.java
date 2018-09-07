package inburst.com.osrshelper.ViewHolder;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import inburst.com.osrshelper.R;
import inburst.com.osrshelper.ViewHolder.Base.BaseViewHolder;
import inburst.com.osrshelper.ViewHolder.Model.TransactionModel;

/**
 * lennyhicks
 * 9/6/18
 */
public class TransactionViewHolder extends BaseViewHolder<TransactionModel> {

    @BindView(R.id.text_item_transaction_date)
    public TextView transactionTime;
    @BindView(R.id.text_item_buy_price)
    public TextView buyPrice;
    @BindView(R.id.text_item_sell_price)
    public TextView sellPrice;
    @BindView(R.id.text_item_buy_quantity)
    public TextView buyQuantity;
    @BindView(R.id.text_item_sell_quantity)
    public TextView sellQuantity;

    public TransactionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(TransactionModel model) {
        transactionTime.setText(model.getTransactionTime());
        buyPrice.setText(model.getBuyPrice());
        sellPrice.setText(model.getSellPrice());
        buyQuantity.setText(model.getBuyQuantity());
        sellQuantity.setText(model.getSellQuantity());
    }
}
