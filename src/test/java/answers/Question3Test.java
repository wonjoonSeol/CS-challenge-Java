package answers;

import helpers.Edge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question3Test {

    @Test
    public void firstExampleShouldReturn1() {
        Edge[] edgelist = {new Edge(new int[] {1, 2}), new Edge(new int[] {2, 3})};
        timeMethod(edgelist, 3, 1);
    }

    @Test
    public void secondExampleShouldReturn3() {
        Edge[] edgelist = {new Edge(new int[] {1, 2}), new Edge(new int[] {1, 3}),
                            new Edge(new int[] {1, 4}), new Edge(new int[] {1, 5})};
        timeMethod(edgelist, 5, 3);
    }

    @Test
    public void thirdExampleShouldReturn1() {
        Edge[] edgelist = {new Edge(new int[] {1, 3}), new Edge(new int[] {1, 4}),
                new Edge(new int[] {1, 5}), new Edge(new int[] {2, 3}), new Edge(new int[] {2, 4}),
                new Edge(new int[] {2, 5})};
        timeMethod(edgelist, 5, 1);
    }

    private void timeMethod(Edge[] edgeList, int numNodes, int expected) {
        long startTime = System.nanoTime();
        assertEquals(expected, Question3.lowestExposureToExchanges(numNodes, edgeList));
        long endTime = System.nanoTime();
        System.out.println("Took "+ (endTime - startTime) + "ns");
    }
}