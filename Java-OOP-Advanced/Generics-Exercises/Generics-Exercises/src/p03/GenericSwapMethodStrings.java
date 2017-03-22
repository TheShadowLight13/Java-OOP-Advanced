package p03;

import java.util.List;

public class GenericSwapMethodStrings {

    public static <T extends Comparable<T>> int countGreaterElements(
            List<T> elements, T comparingValue) {

        int greaterElementsCount = 0;

        for (T element : elements) {
            if (element.compareTo(comparingValue) > 0) {
                greaterElementsCount++;
            }
        }

        return greaterElementsCount;
    }
}
