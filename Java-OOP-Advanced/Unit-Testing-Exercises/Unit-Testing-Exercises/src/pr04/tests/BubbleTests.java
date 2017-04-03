package pr04.tests;

import org.junit.Before;
import org.junit.Test;
import pr04.interfaces.IBubble;
import pr04.models.Bubble;
import java.util.ArrayList;
import java.util.List;

public class BubbleTests {

    private IBubble bubble;
    private List<Integer> numbers;

    @Before
    public void initializeTestObjects() {
        this.bubble = new Bubble(new ArrayList<>());
        this.numbers = new ArrayList<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPassNullInCtorThrowsException() {
        this.bubble = new Bubble(null);
    }

    @Test
    public void testEstimatedTimeForBigCollectionSort() {
        for (int i = 100_000; i >= 0 ; i--) {
            this.numbers.add(i);
        }

        this.bubble = new Bubble(this.numbers);
        long startTime = System.nanoTime();
        this.bubble.sort();
        long estimatedTime = (System.nanoTime() - startTime) / 1_000_000;
        System.out.println("Estimated time for bubble sort: " + estimatedTime);
    }
}
