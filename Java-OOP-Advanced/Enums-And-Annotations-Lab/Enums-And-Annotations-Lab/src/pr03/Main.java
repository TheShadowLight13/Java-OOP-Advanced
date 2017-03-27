package pr03;

public class Main {

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.insertCoin("twenty");
        coffeeMachine.insertCoin("TWENTY");
        coffeeMachine.insertCoin("TWENTY");
        coffeeMachine.buyCoffee("Small", "Espresso");

        for (Coffee coffee : coffeeMachine.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}
