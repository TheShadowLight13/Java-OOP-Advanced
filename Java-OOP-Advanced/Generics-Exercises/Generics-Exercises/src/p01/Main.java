package p01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            GenericBox genericBox = new GenericBox<>(Integer.valueOf(reader.readLine()));
            System.out.println(genericBox);
        }
    }
}
