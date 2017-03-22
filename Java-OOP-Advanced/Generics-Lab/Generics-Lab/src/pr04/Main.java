package pr04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> source = new ArrayList<>();
        Collections.addAll(source, "asd", "dsds", "fsdsd");

        List<String> destination = new ArrayList<>();
        ListUtils.addAll(destination, source);
    }
}
