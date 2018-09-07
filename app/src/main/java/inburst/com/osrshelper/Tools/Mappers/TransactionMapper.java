package inburst.com.osrshelper.Tools.Mappers;

import inburst.com.osrshelper.Entity.EntityTransaction;
import inburst.com.osrshelper.Tools.Formatter;
import inburst.com.osrshelper.ViewHolder.Model.TransactionModel;

/**
 * lennyhicks
 * 9/6/18
 */
public class TransactionMapper extends BaseMapper<EntityTransaction, TransactionModel> {
    @Override
    public TransactionModel from(EntityTransaction entity) {
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setTransactionTime(Formatter.formatDate(entity.getTs()));
        transactionModel.setBuyPrice(Formatter.numberToString(entity.getBuyingPrice()));
        transactionModel.setBuyQuantity(Formatter.numberToString(entity.getBuyingCompleted()));
        transactionModel.setSellPrice(Formatter.numberToString(entity.getSellingPrice()));
        transactionModel.setSellQuantity(Formatter.numberToString(entity.getSellingCompleted()));
        return transactionModel;
    }
}
