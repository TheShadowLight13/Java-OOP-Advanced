package pr03;

public class Coffee {

    private CoffeeSize coffeeSize;
    private CoffeeType coffeeType;

    public Coffee(CoffeeSize coffeeSize, CoffeeType coffeeType) {
        this.coffeeSize = coffeeSize;
        this.coffeeType = coffeeType;
    }

    public int getPrice() {
        return this.coffeeSize.getPrice();
    }

    @Override
    public String toString() {
        return String.format("%s %s",
                this.coffeeType.name().toUpperCase(),
                this.coffeeSize);
    }
}
