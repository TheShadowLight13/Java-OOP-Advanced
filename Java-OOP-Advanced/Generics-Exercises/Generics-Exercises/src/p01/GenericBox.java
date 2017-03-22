package p01;

public class GenericBox<T> {
    private T value;

    public GenericBox(T value) {
        this.setValue(value);
    }

    public T getValue() {
        return this.value;
    }

    private void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",
                this.getValue().getClass().getName(),
                this.getValue());
    }
}
