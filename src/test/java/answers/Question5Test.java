package answers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question5Test {

    @Test
    public void firstExampleShouldReturn2() {
        int[] arr = {1, 3, 4};
        long startTime = System.nanoTime();
        assertEquals(2, Question5.shareExchange(arr, 6));
        long endTime = System.nanoTime();
        System.out.println("Took "+ (endTime - startTime) + "ns");
    }

    @Test
    public void secondExampleShouldReturn2() {
        int[] arr = {3, 4};
        long startTime = System.nanoTime();
        assertEquals(2, Question5.shareExchange(arr, 6));
        long endTime = System.nanoTime();
        System.out.println("Took "+ (endTime - startTime) + "ns");
    }

}