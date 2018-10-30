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

    @Test
    public void notAllocatedCase() {
        int[] arr = {7, 4};
        timeMethod(arr, 10, 0);

        int[] arr1 = {11};
        timeMethod(arr1, 10, 0);
    }

    private void timeMethod(int[] arr, int total, int expected) {
        long startTime = System.nanoTime();
        assertEquals(expected, Question5.shareExchange(arr, total));
        long endTime = System.nanoTime();
        System.out.println("Took "+ (endTime - startTime) + "ns");
    }

}