package inburst.com.osrshelper.Tools.Mappers;

import java.util.ArrayList;
import java.util.List;

import inburst.com.osrshelper.Entity.EntityTransaction;
import inburst.com.osrshelper.ViewHolder.Model.TransactionModel;

/**
 * lennyhicks
 * 9/6/18
 */
public class ListTransactionMapper extends BaseMapper<List<EntityTransaction>, List<TransactionModel>> {

    private TransactionMapper transactionMapper = new TransactionMapper();

    @Override
    public List<TransactionModel> from(List<EntityTransaction> entityTransactions) {

        ArrayList<TransactionModel> items = new ArrayList<>();
        for(EntityTransaction entityTransaction : entityTransactions) {
            items.add(transactionMapper.from(entityTransaction));
        }
        return items;
    }
}
