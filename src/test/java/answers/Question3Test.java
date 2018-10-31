package answers;

import helpers.Edge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question3Test {

    @Test
    public void firstExampleShouldReturn1() {
        Edge[] edgelist = {new Edge(new int[] {1, 2}), new Edge(new int[] {2, 3})};
        timeMethod(edgelist, 3, 1);

        Edge[] edgelist1 = {new Edge(new int[] {2, 1}), new Edge(new int[] {3, 2})};
        timeMethod(edgelist1, 3, 1);
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


    @Test
    public void disjointExchanges() {
        Edge[] edgelist = {new Edge(new int[] {1, 3}), new Edge(new int[] {3, 4}),
                new Edge(new int[] {2, 6}), new Edge(new int[] {2, 5}), new Edge(new int[] {7, 8})};
        timeMethod(edgelist, 8, 2);

        Edge[] edgelist1 = {new Edge(new int[] {1, 2}), new Edge(new int[] {2, 3}),
                new Edge(new int[] {1, 3}), new Edge(new int[] {4, 5}),
                new Edge(new int[] {4, 6}), new Edge(new int[] {5, 6})};
        timeMethod(edgelist1, 6, 2);
    }

    @Test
    public void edgeCase1() {
        Edge[] edgelist = {new Edge(new int[] {1, 2}), new Edge(new int[] {2, 3}),
                new Edge(new int[] {1, 3})};
        timeMethod(edgelist, 3, 1);
    }

    @Test
    public void treeStructureTest() {
        Edge[] edgelist = {new Edge(new int[]{2, 1}), new Edge(new int[]{3, 1}),
                new Edge(new int[]{4, 2}), new Edge(new int[]{5, 2}),
                new Edge(new int[]{6, 3}), new Edge(new int[]{7, 5}), new Edge(new int[]{8, 5})
        };
        timeMethod(edgelist, 8, 2);
    }

    @Test
    public void badChoicePunisher() {
        // has one disjoint vertex 6
        Edge[] edgelist = {new Edge(new int[] {1, 7}), new Edge(new int[] {1, 8}),
                new Edge(new int[] {7, 3}), new Edge(new int[] {3, 2}), new Edge(new int[] {2, 4}),
                new Edge(new int[] {2, 5})};
        timeMethod(edgelist, 8, 2);


        Edge[] edgelist1 = {new Edge(new int[] {1, 6}), new Edge(new int[] {1, 7}),
                new Edge(new int[] {6, 3}), new Edge(new int[] {3, 2}), new Edge(new int[] {2, 4}),
                new Edge(new int[] {2, 5})};
        timeMethod(edgelist1, 7, 1);

        Edge[] edgelist2 = {new Edge(new int[] {1, 6}), new Edge(new int[] {1, 7}),
                new Edge(new int[] {6, 3}), new Edge(new int[] {3, 2}), new Edge(new int[] {2, 4}),
                new Edge(new int[] {2, 5}), new Edge(new int[] {2, 8})};
        timeMethod(edgelist2, 8, 2);

        Edge[] edgelist3 = {new Edge(new int[] {1, 6}), new Edge(new int[] {1, 7}),
                new Edge(new int[] {6, 3}), new Edge(new int[] {3, 2}), new Edge(new int[] {2, 4}),
                new Edge(new int[] {2, 5})};
        timeMethod(edgelist3, 7, 1);
    }

    @Test
    public void NoEdgeList() {
        Edge[] edgelist = {};
        timeMethod(edgelist, 5, 5);
    }

    @Test
    public void ZeroNode() {
        Edge[] edgelist = {};
        timeMethod(edgelist, 0, 0);
    }

    private void timeMethod(Edge[] edgeList, int numNodes, int expected) {
        long startTime = System.nanoTime();
        assertEquals(expected, Question3.lowestExposureToExchanges(numNodes, edgeList));
        long endTime = System.nanoTime();
        System.out.println("Took "+ (endTime - startTime) + "ns");
    }
}