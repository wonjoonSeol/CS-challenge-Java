package answers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question6Test {

    @Test
    public void firstExampleShouldReturn6() {
        int[][] arr = {{0, 7, 4}, {7, 0, 2}, {4, 2, 0}};
        timeMethod(arr, 3, 1, 6);
    }

    private void timeMethod(int[][] arr, int numServers, int targetServer, int expected) {
        long startTime = System.nanoTime();
        assertEquals(expected, Question6.shortestServerRoute(numServers,targetServer, arr));
        long endTime = System.nanoTime();
        System.out.println("Took "+ (endTime - startTime) + "ns");
    }
}