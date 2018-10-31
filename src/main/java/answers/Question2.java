package answers;

import java.util.*;

public class Question2 {

	public static int equallyBalancedCashFlow(int[] cashflowIn, int[] cashflowOut) {
		if (cashflowIn.length < cashflowOut.length) {
			return smallestDifference(cashflowIn, cashflowOut);
		} else {
			return smallestDifference(cashflowOut, cashflowIn);
		}
	}

	public static int smallestDifference(int[] shorter, int[] longer) {
		List<Integer> permutations = new ArrayList<Integer>();
		generatePermutation(shorter, 0, 0, permutations);

//		System.out.println(permutations);
		int minDifference = Integer.MAX_VALUE;
		for (int sum : permutations) {
			Map<String, Integer> memo = new HashMap<>();
			int temp = findSum(longer, sum, 0, memo);
			if (temp < minDifference) minDifference = temp;
//			System.out.println(minDifference);
		}
		return minDifference;
	}

	public static int findSum(int[] longer, int total, int k, Map<String, Integer> memo) {
		if (total <= 0 || k == longer.length) return Math.abs(total);
		if (memo.containsKey(total + ":" + k)) return memo.get(total+":"+k);
		return Math.min(findSum(longer, total - longer[k], k + 1, memo), findSum(longer, total, k + 1, memo));
	}

	public static void generatePermutation(int[] shorter, int k, int sum, List<Integer> result) {
		if (k == shorter.length) {
			result.add(sum);
		} else {
			generatePermutation(shorter, k + 1, sum + shorter[k], result);
			if (k != shorter.length - 1) generatePermutation(shorter, k + 1, sum, result);
		}
	}

	/*
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
	*/
}
