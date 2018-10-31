package answers;

import helpers.Edge;

public class Question3 {
    private static boolean[][] graph;

    public static int lowestExposureToExchanges(int numNodes, Edge[] edgeList) {
        if (numNodes == 0) return 0;
        if (edgeList.length == 0) return numNodes;

        graph = new boolean[numNodes + 1][numNodes + 1];
        for (Edge edge : edgeList) {
            int a = edge.getEdgeA();
            int b = edge.getEdgeB();
            graph[a][b] = true;
            graph[b][a] = true;
        }

        int minCover = findMinCover(numNodes, edgeList.length);
//        System.out.println("Min Cover " + minCover);
        int maxIndependentSet = numNodes - minCover;
//        System.out.println("Max Ind " + maxIndependentSet);
        int remaining = numNodes - maxIndependentSet;
//        System.out.println("remaining " + remaining);
        return Math.abs(maxIndependentSet - remaining);
    }

    public static boolean isCover(int V, int k, int E) {
        int set = (1 << k) - 1;
        int limit = (1 << V);

        boolean[][] vis = new boolean[V + 1][V + 1];
        while (set < limit) {
            int counter = 0;

            for (int i = 1, v = 1 ; i < limit ; i = i << 1, v++) {
                if ((set & i) > 0) {
                    for (int j = 1 ; j <= V ; j++) {
                        if (graph[v][j] && !vis[v][j]) {
                            vis[v][j] = true;
                            vis[j][v] = true;
                            counter++;
                        }
                    }
                }
            }

            if (counter == E) return true;
            int c = set & -set;
            int r = set + c;
            set = (((r^set) >> 2) / c) | r;
        }
        return false;
    }

    public static int findMinCover(int n, int m) {
        int left = 1, right = n;
        while (right > left) {
            int mid = (left + right) >> 1;
            if (isCover(n, mid, m) == false) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    /* Assumes tree
    public static class Node {
        int name;
        int independentSize;
        List<Node> children;

        public Node(int name) {
            this.name = name;
            this.independentSize = 0;
            children = new ArrayList<>();
        }
    }

    public static int lowestExposureToExchanges(int numNodes, Edge[] edgeList) {
        if (numNodes == 0) return 0;
        Node[] nodes = new Node[numNodes + 1];
        for (int i = 1; i <= numNodes; i++) {
            nodes[i] = new Node(numNodes);
        }

        for (Edge edge : edgeList) {
            if (edge.getEdgeA() < edge.getEdgeB()) {
                nodes[edge.getEdgeA()].children.add(nodes[edge.getEdgeB()]);
            } else {
                nodes[edge.getEdgeB()].children.add(nodes[edge.getEdgeA()]);
            }
        }

        int result = getIndependentSize(nodes[1]);
        int remaining = numNodes - result;
        return result - remaining;
    }

    public static int getIndependentSize(Node node) {

        if (node.independentSize != 0) return node.independentSize;
        if (node.children.isEmpty()) {
           node.independentSize = 1;
           return 1;
        }

        int childrenIndependent = 0;
        for (Node child : node.children) {
           childrenIndependent += getIndependentSize(child);
        }

        // Calculate size including the current node
        int thisIndependent = 1;
        for (Node child : node.children) {
            for (Node grandChild : child.children) {
                thisIndependent += getIndependentSize(grandChild);
            }
        }
        return node.independentSize = Math.max(thisIndependent, childrenIndependent);
    }
*/

    /* Not 'MIN' possible exchanges, or it doesn't find MAX vertex cover
    public static int checkedNodes;

	public static int lowestExposureToExchanges(int numNodes, Edge[] edgeList) {
	    if (edgeList.length == 0) return numNodes;
        checkedNodes = 0;

	    Map<Integer, Set> map = new HashMap<>();
		for (Edge edge : edgeList) {
			int a = edge.getEdgeA();
			int b = edge.getEdgeB();

			Set setA = map.getOrDefault(a, new HashSet<Integer>());
			setA.add(b);
			map.put(a, setA);
			Set setB = map.getOrDefault(b, new HashSet<Integer>());
			setB.add(a);
			map.put(b, setB);
		}

        boolean[] checked = new boolean[numNodes + 1];
        LinkedList<Node> queue = new LinkedList();

        int exchanges = 0;
        while (checkedNodes != numNodes) {
            fillQueue(queue, checked, numNodes);
            int maxExchange = maxExchanges(map, queue, checked);
            System.out.println(maxExchange);
            exchanges += maxExchange;
        }
        int remaining = numNodes - exchanges;
        return Math.abs(exchanges - remaining);
	}

	public static int maxExchanges(Map<Integer, Set> map, LinkedList<Node> queue, boolean[] checked) {
	    int localNodes = 0, independent = 0;
        while (!queue.isEmpty()) {
            Node currentNode = queue.pop();
            int i = currentNode.name;
            System.out.println("Current node " + i + " " + currentNode.isIndependent);
            if (currentNode.isIndependent) independent++;
            checkedNodes++;
            localNodes++;
            if (map.containsKey(i)) {
                Iterator<Integer> itr = map.get(i).iterator();
                while (itr.hasNext()) {
                    int temp = itr.next();
                    if (!checked[temp]) {
                        queue.addLast(new Node(temp, !currentNode.isIndependent));
                        checked[temp] = true;
                    }
                }
            }

        }
        System.out.println("local nodes " + localNodes + ", independent " + independent);
        // take maximum as bigger is trading exchanges.
        return Math.max(localNodes - independent, independent);
    }

    public static void fillQueue(LinkedList<Node> queue, boolean[] checked, int numNodes) {
        for (int i = 1; i <= numNodes; i++) {
            if (!checked[i]) {
//                System.out.println("Fill queue with " + i);
                checked[i] = true;
                queue.add(new Node(i, true));
                break;
            }
        }
    }

	public static class Node {
	    public boolean isIndependent;
	    public int name;

	    public Node(int name, boolean isIndependent) {
	        this.isIndependent = isIndependent;
	        this.name = name;
        }
    }
    */
}
