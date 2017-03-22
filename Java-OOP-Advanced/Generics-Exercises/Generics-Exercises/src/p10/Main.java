package p10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split("\\s+");
        String name = data[0] + " " + data[1];
        String address = data[2];
        String town = data[3];

        List<IThreeuple> threeuples = new ArrayList<>();

        IThreeuple<String, String, String> threeuple1 = new Threeuple<>(name, address, town);
        threeuples.add(threeuple1);

        data = reader.readLine().split("\\s+");
        name = data[0];
        int amountOfBeer = Integer.valueOf(data[1]);
        boolean isDrunk = data[2].equals("drunk");

        IThreeuple<String, Integer, Boolean> threeuple2 = new Threeuple<>(name, amountOfBeer, isDrunk);
        threeuples.add(threeuple2);

        data = reader.readLine().split("\\s+");
        name = data[0];
        double bankBalance = Double.valueOf(data[1]);
        String bankName = data[2];
        
        IThreeuple<String, Double, String> threeuple3 = new Threeuple<>(name, bankBalance, bankName);
        threeuples.add(threeuple3);

        for (IThreeuple threeuple : threeuples) {
            System.out.printf("%s -> %s -> %s%n",
                    threeuple.getItem1(),
                    threeuple.getItem2(),
                    threeuple.getItem3());
        }
    }
}
