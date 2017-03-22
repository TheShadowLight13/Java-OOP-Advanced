package p10;

public class Threeuple<T, E, P> implements IThreeuple<T, E, P>{

    private T item1;
    private E item2;
    private P item3;

    public Threeuple(T item1, E item2, P item3) {
        this.setItem1(item1);
        this.setItem2(item2);
        this.setItem3(item3);
    }

    private void setItem1(T item1) {
        this.item1 = item1;
    }

    private void setItem2(E item2) {
        this.item2 = item2;
    }

    private void setItem3(P item3) {
        this.item3 = item3;
    }

    @Override
    public T getItem1() {
        return this.item1;
    }

    @Override
    public E getItem2() {
        return this.item2;
    }

    @Override
    public P getItem3() {
        return this.item3;
    }
}
