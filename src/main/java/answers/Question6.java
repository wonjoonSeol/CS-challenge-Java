package answers;

import java.util.Stack;

public class Question6 {

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
}
