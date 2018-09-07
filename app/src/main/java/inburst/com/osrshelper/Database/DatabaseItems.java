package inburst.com.osrshelper.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import inburst.com.osrshelper.Entity.EntityItem;

/** lennyhicks 9/4/18 */
@Database(
  entities = {EntityItem.class},
  version = 1,
  exportSchema = false
)
public abstract class DatabaseItems extends RoomDatabase {
  public abstract DaoItem daoAccess();
}
