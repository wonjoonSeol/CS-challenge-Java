package answers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question2 {

	public static int equallyBalancedCashFlow(int[] cashflowIn, int[] cashflowOut) {
		Arrays.sort(cashflowIn);
		Arrays.sort(cashflowOut);

		System.out.println("Sorted\ncashflow IN " + Arrays.toString(cashflowIn));
		System.out.println("Cashflow Out " + Arrays.toString(cashflowOut));
		if (cashflowIn.length < cashflowOut.length) {
			return smallestDifference(cashflowIn, cashflowOut, new ArrayList<Integer>(), new ArrayList<Integer>());
		} else {
			return smallestDifference(cashflowOut, cashflowIn, new ArrayList<Integer>(), new ArrayList<Integer>());
		}
	}

	public static int smallestDifference(int[] shorter, int[] longer, List<Integer> positives, List<Integer> negatives) {
		for (int firstNum : shorter) {
			int min = Integer.MAX_VALUE;
			for (int secondNum : longer) {
				int difference = firstNum - secondNum;
				if (Math.abs(difference) < min) {
					min = difference;
				} else {
					break;
				}
			}
			if (min >= 0) {
				positives.add(min);
			} else {
				negatives.add(min);
			}
		}
		positives.sort(Integer::compareTo);
		negatives.sort(Collections.reverseOrder());

		System.out.println("Positives " + positives);
		System.out.println("Negatives " + negatives);

		int min = Integer.MAX_VALUE;
		for (int positive : positives) {
		    for (int negative : negatives) {
		    	int difference = Math.abs(positive + negative);
				if (difference == 0) return 0;
				if (difference < min) min = difference;
			}
		}
		return min;
	}
}
