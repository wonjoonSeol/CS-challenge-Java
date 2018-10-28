package answers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question2Test {

    @Test
    public void firstExampleShouldReturn0() {
        int[] cashflow_in = {66, 293, 215, 188, 147, 326, 449, 162, 46, 350};
        int[] cashflow_out = {170, 153, 305, 290, 187};

        timeMethod(cashflow_in, cashflow_out, 0);
    }

    @Test
    public void secondExampleShouldReturn8() {
        int[] cashflow_in = {189, 28};
        int[] cashflow_out = {43, 267, 112, 166};

        timeMethod(cashflow_in, cashflow_out, 8);
    }

    @Test
    public void thirdExampleShouldReturn1() {
        int[] cashflow_in = {72, 24, 73, 4, 28, 56, 1, 43};
        int[] cashflow_out = {27};

        timeMethod(cashflow_in, cashflow_out, 1);
    }

    private void timeMethod(int[] cashflow_in, int[] cashflow_out, int expected) {
        long startTime = System.nanoTime();
        assertEquals(expected, Question2.equallyBalancedCashFlow(cashflow_in, cashflow_out));
        long endTime = System.nanoTime();
        System.out.println("Took "+ (endTime - startTime) + "ns");
    }
}