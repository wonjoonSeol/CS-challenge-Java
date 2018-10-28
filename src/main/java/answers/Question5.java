package answers;

import java.util.Arrays;

public class Question5 {

	public static int shareExchange(int[] allowedAllocations, int totalValue) {
		Arrays.sort(allowedAllocations);
		boolean isAllocated = false;
//		System.out.println(Arrays.toString(allowedAllocations));
		int num = 0;
		for (int i = allowedAllocations.length - 1; i >= 0; i--) {
			totalValue -= allowedAllocations[i];
			num++;
			if (totalValue <= 0) {
				isAllocated = true;
				break;
			}
		}
		if (isAllocated) return num;
		return 0;
	}

	// memoisation
}
