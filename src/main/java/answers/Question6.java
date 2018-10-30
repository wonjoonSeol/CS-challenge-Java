package answers;

import java.util.List;
import java.util.Stack;

public class Question6 {

    public static int shortestServerRoute(int numServers, int targetServer, int[][] times) {
        int[] memo = new int[numServers];
        for (int i = 0; i < numServers; i++) {
            memo[i] = Integer.MAX_VALUE;
        }
        return findShortestPath(numServers, 0, targetServer, times, memo);
    }

    public static int findShortestPath(int numServers, int current, int targetServer, int[][] times, int[] memo) {
        int min = Integer.MAX_VALUE;
        if (current == targetServer) return 0;
        if (numServers == 0) return Integer.MAX_VALUE;

        for (int i = 0; i < numServers; i++) {
            if (i == current) continue;
//            if (min < times[current][i]) continue;

            int temp;
            if (memo[current] != Integer.MAX_VALUE) {
                temp = memo[current];
            } else {
                temp = findShortestPath(numServers - 1, i, targetServer, times, memo);
            }

            if (temp != Integer.MAX_VALUE && temp + times[current][i] < min) {
                min = temp + times[current][i];
            }
        }

        memo[current] = min;
        return min;
    }

    /*
	public static int shortestServerRoute(int numServers, int targetServer, int[][] times) {
		if (numServers == 0) return 0;
		int min = Integer.MAX_VALUE;

		Stack<Path> paths = new Stack<>();
		paths.push(new Path());

		while (!paths.isEmpty()) {
			Path path = paths.pop();
			int current = path.getVisited().get(path.getVisited().size() - 1);
			for (int i = 0; i < numServers; i++) {
				if (current == targetServer) {
					if (path.getDistance() < min) {
						min = path.getDistance();
						break;
					}
					// consider hash
				} else if (current != i && !path.getVisited().contains(i)) {
					Path newPath = new Path(path, i, times[current][i]);
					paths.push(newPath);
				}
			}
		}
		return min;
	}
	*/
}
