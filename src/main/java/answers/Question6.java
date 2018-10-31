package answers;

import java.util.PriorityQueue;

public class Question6 {
    private static int[] distance;

    /*
    // Heap O(VlogE) implementation, in this question E = V.
    public static int shortestServerRoute(int numServers, int targetServer, int[][] times) {
        distance = new int[numServers];
        int[] nodeStatus = new int[numServers];     // priority queue doesn't auto reorder
        boolean[] isUsed = new boolean[numServers]; // because E = V
        PriorityQueue<Node> heap = new PriorityQueue<>(numServers);

        heap.add(new Node(0));
        distance[0] = 0;
        for (int i = 1; i < numServers; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int run = 0; run < numServers; run++) {
            Node node = heap.poll();

            // skip old nodes
            while (node.status != nodeStatus[node.name]) {
               node = heap.poll();
            }

            int current = node.name;
            isUsed[current] = true;
            // every node connected to another
            for (int i = 0; i < numServers; i++) {
                if (i == current || isUsed[i]) continue;
                int time = distance[current] + times[current][i];
                if (distance[current] != Integer.MAX_VALUE && time < distance[i]) {
                    distance[i] = time;
                    nodeStatus[i]++;
                    heap.add(new Node(i, nodeStatus[i]));
                }
            }
        }
        return distance[targetServer];
    }


    public static class Node implements Comparable<Node>{
        public int name;
        public int status;

        public Node(int name) {
            this.name = name;
        }

        public Node(int name, int status) {
            this.name = name;
            this.status = status;
        }

        public int getDistance() {
            return distance[name];
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(getDistance(), o.getDistance());
        }

//        @Override
//        public boolean equals(Object obj) {
//            if (obj instanceof Node) {
//                return name == ((Node) obj).name;
//            }
//            return false;
//        }
    }

*/


    // O(V^2) Dijkstra
    public static int shortestServerRoute(int numServers, int targetServer, int[][] times) {
        boolean[] isUsed = new boolean[numServers];
        int[] distance = new int[numServers];
        distance[0] = 0;
        for (int i = 1; i < numServers; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int count = 0; count < numServers; count++) {
            //System.out.println(Arrays.toString(distance));
            //System.out.println(Arrays.toString(isUsed));
            int nodeIndex = getMin(isUsed, distance);
            isUsed[nodeIndex] = true;
            //System.out.println("node Index " + nodeIndex);

            for (int j = 0; j < numServers; j++) {
                if (nodeIndex == j) continue;
                if (!isUsed[j] && distance[nodeIndex] != Integer.MAX_VALUE
                        && distance[nodeIndex] + times[nodeIndex][j] < distance[j]) {
                    distance[j] = distance[nodeIndex] + times[nodeIndex][j];
                }
            }
        }
        return distance[targetServer];
    }

    public static int getMin(boolean[] isUsed, int[] distance) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < isUsed.length; i++) {
            if (!isUsed[i] && distance[i] < min) {
                min = distance[i];
                index = i;
            }
        }
        return index;
    }




    // ------------- Previous methods -------------- //

    /*
    public static int shortestServerRoute(int numServers, int targetServer, int[][] times) {
        int[] memo = new int[numServers];
        for (int i = 0; i < numServers; i++) {
            memo[i] = Integer.MAX_VALUE;
        }
        return findShortestPath(numServers, 0, targetServer, times, memo);
    }
    */
    /*
    public static int findShortestPath(int numServers, int current, int targetServer, int[][] times, int[] memo) {
        int min = memo[current];
        if (current == targetServer) return 0;
        if (numServers == 0) return Integer.MAX_VALUE;

        for (int i = 0; i < numServers; i++) {
            if (i == current) continue;
            if (min < times[current][i]) continue;      // minPossible so far < new edge
            int temp = memo[current] != Integer.MAX_VALUE ? memo[current] :
                    findShortestPath(numServers - 1, i, targetServer, times, memo);

            if (temp != Integer.MAX_VALUE && temp + times[current][i] < min) {
                min = temp + times[current][i];
            }
        }
        memo[current] = min;
        return min;
    }
    j*/
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
