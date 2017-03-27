package pr03;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    List<Coffee> coffeeList;
    List<Coin> coins;

    public CoffeeMachine() {
        this.coffeeList = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    public void buyCoffee(String size, String type) {
        CoffeeSize coffeeSize = CoffeeSize.valueOf(size.toUpperCase());
        CoffeeType coffeeType = CoffeeType.valueOf(type.toUpperCase());
        Coffee coffee = new Coffee(coffeeSize, coffeeType);
        int price = coffee.getPrice();

        int currentSum = this.coins.stream().mapToInt(Coin::getValue).sum();
        if (currentSum > price) {
            this.coffeeList.add(coffee);
            this.coins.clear();
        }
    }

    public void insertCoin(String coin) {
        Coin currCoin = Coin.valueOf(coin.toUpperCase());
        this.coins.add(currCoin);
    }

    public Iterable<Coffee> coffeesSold() {
        return this.coffeeList;
    }
}
