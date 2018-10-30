package answers;

import java.util.HashMap;
import java.util.Map;

public class Question5 {

	public static int shareExchange(int[] allowedAllocations, int totalValue) {
		int result = minAllocations(allowedAllocations, new HashMap<Integer, Integer>(), totalValue);
		return result == Integer.MAX_VALUE ? 0 : result;
	}


	public static int minAllocations(int[] allowedAllocations, Map<Integer, Integer> memo, int total) {
        if (total == 0) return 0;
        int result = Integer.MAX_VALUE;
        for (int allocation : allowedAllocations) {
            if (total < allocation) continue;
            int current = total - allocation;
            int temp;

            if (memo.containsKey(current)) {
                temp = memo.get(current);
            } else {
                temp = Math.min(result, minAllocations(allowedAllocations, memo, current));
            }

            temp = temp == Integer.MAX_VALUE ? temp : temp + 1;
            if (temp < result) result = temp;

        }
        memo.put(total, result);
        return result;
    }
}