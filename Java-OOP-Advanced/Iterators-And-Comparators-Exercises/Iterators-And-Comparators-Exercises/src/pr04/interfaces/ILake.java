package pr04.interfaces;

public interface ILake<T> extends Iterable<T> {
    void add(T element);
}
