public interface Filter<T> {

	boolean meetsCondition(T obj);
}
