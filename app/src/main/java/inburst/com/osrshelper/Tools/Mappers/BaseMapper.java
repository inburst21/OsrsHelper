package inburst.com.osrshelper.Tools.Mappers;

/**
 * lennyhicks
 * 9/6/18
 */
public abstract class BaseMapper<T, V> {
    public abstract V from(T entity);
}
