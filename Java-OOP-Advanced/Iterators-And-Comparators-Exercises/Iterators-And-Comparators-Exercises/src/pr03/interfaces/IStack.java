package pr03.interfaces;

public interface IStack<T> extends Iterable<T>{
    void push(T element);

    T pop();
}
