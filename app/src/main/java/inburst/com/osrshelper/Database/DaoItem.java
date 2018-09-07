package inburst.com.osrshelper.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import inburst.com.osrshelper.Entity.EntityItem;
import io.reactivex.Flowable;

/** lennyhicks 9/4/18 */
@Dao
public interface DaoItem {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertItem(EntityItem item);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertListItems(List<EntityItem> rsItemList);

  @Update(onConflict = OnConflictStrategy.REPLACE)
  void updateItem(EntityItem rsItem);

  @Delete
  void deleteItem(EntityItem rsItem);

  @Query("Select * From EntityItem")
  Flowable<EntityItem> getItems();
}
