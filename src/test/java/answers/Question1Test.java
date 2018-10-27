package answers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Question1Test {

    @Test
    public void example1ShouldReturn15() {
        int[] portfolio = {15, 8, 6, 7};
        long startTime = System.nanoTime();
        assertEquals(15, Question1.bestMergedPortfolio(portfolio));
        long endTime = System.nanoTime();
        System.out.println("Took "+ (endTime - startTime) + "ns");
    }

    @Test
    public void example2ShouldReturn14() {
        int[] portfolio = {9, 7, 12, 2};
        long startTime = System.nanoTime();
        assertEquals(14, Question1.bestMergedPortfolio(portfolio));
        long endTime = System.nanoTime();
        System.out.println("Took "+ (endTime - startTime) + "ns");
    }

    // remove dup, hashset
    @Test
    public void sameNumberShouldReturn0() {
        int[] portfolio = {100, 100, 100, 100, 100};
        long startTime = System.nanoTime();
        assertEquals(0, Question1.bestMergedPortfolio(portfolio));
        long endTime = System.nanoTime();
        System.out.println("Took "+ (endTime - startTime) + "ns");
    }

    @Test
    public void EmptySetShouldReturn0() {
        int[] portfolio = {};
        long startTime = System.nanoTime();
        assertEquals(0, Question1.bestMergedPortfolio(portfolio));
        long endTime = System.nanoTime();
        System.out.println("Took "+ (endTime - startTime) + "ns");
    }

    @Test
    public void maxValueTest() {
        int[] portfolio = {65535,65535,65535,65535,65535,65535,0,65535,65535,65535};
        long startTime = System.nanoTime();
        assertEquals(65535, Question1.bestMergedPortfolio(portfolio));
        long endTime = System.nanoTime();
        System.out.println("Took "+ (endTime - startTime) + "ns");
    }

    @Test
    public void oneValue() {
        int[] portfolio = {65535};
        long startTime = System.nanoTime();
        assertEquals(65535, Question1.bestMergedPortfolio(portfolio));
        long endTime = System.nanoTime();
        System.out.println("Took "+ (endTime - startTime) + "ns");
    }

    @Test
    public void twoValueTest() {
        int[] portfolio = {7, 8};
        long startTime = System.nanoTime();
        assertEquals(15, Question1.bestMergedPortfolio(portfolio));
        long endTime = System.nanoTime();
        System.out.println("Took "+ (endTime - startTime) + "ns");
    }
}