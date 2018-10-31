package answers;

public class Question5 {

	public static int shareExchange(int[] allowedAllocations, int totalValue) {
//		int result = minAllocations(allowedAllocations, new HashMap<Integer, Integer>(), totalValue);
		int result = minAllocations(allowedAllocations, totalValue);
		return result == Integer.MAX_VALUE ? 0 : result;
	}


	public static int minAllocations(int[] allowedAllocations, int total) {
        int[] memo = new int[total + 1];
        // Base case (If given value V is 0)
        memo[0] = 0;
        // Initialize all table values as Infinite
        for (int i = 1; i <= total; i++) {
            memo[i] = Integer.MAX_VALUE;
        }
        // Compute minimum coins required for all
        // values from 1 to total
        for (int i = 1; i <= total; i++) {
            // Go through all coins smaller than i
            for (int j = 0; j < allowedAllocations.length; j++) {
                if (allowedAllocations[j] <= i) {
                    int temp = memo[i - allowedAllocations[j]];
                    if (temp != Integer.MAX_VALUE && temp + 1 < memo[i])
                        memo[i] = temp + 1;
                }
            }
        }
        return memo[total];
    }

    /*
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
   */
}