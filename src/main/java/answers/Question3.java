package answers;

import helpers.Edge;

import java.util.*;

public class Question3 {
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
//            System.out.println(maxExchange);
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
//            System.out.println("Current node " + i + " " + currentNode.isIndependent);
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
//        System.out.println("local nodes " + localNodes + ", independent " + independent);
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
}
