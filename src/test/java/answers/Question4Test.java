package answers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question4Test {

    @Test
    public void firstExampleShouldReturn24() {
        String[][] arr = {{"12", "12", "3", "X", "3"}, {"23", "X", "X", "X", "3"},
                {"33", "21", "X", "X", "X"}, {"9", "12", "3", "X", "X"}, {"X", "X", "X", "4", "5"}};

        timeMethod(arr, 3, 24);
    }

    @Test
    public void secondExampleShouldReturn24() {
        String[][] arr = {{"X", "X", "2"}, {"2", "3", "X"}, {"X", "3", "2"}};
        timeMethod(arr, 3, 0);
    }

    @Test
    public void thirdExampleShouldReturn5() {
        String[][] arr = {{"2", "3", "X", "2"}, {"4", "X", "X", "4"}, {"3", "2", "X", "X"}, {"X", "X", "X", "5"}};
        timeMethod(arr, 2, 5);
    }

    private void timeMethod(String[][] arr, int numberMachines, int expected) {
        long startTime = System.nanoTime();
        assertEquals(expected, Question4.selectionFailedTradedesks(arr, numberMachines));
        long endTime = System.nanoTime();
        System.out.println("Took "+ (endTime - startTime) + "ns");
    }
}