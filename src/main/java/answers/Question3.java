package answers;

import helpers.Edge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question3 {

	// consider bitarray
	public static int lowestExposureToExchanges(int numNodes, Edge[] edgeList) {
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

		Set<Integer> exchanges = new HashSet<>();
		for (int i = 1; i <= numNodes; i++) {
			if (exchanges.contains(i)) continue;
			if (map.containsKey(i)) exchanges.addAll(map.get(i));
		}

		// number can be either trading exchanges or avoiding exchanges
		int number = exchanges.size();
//		System.out.println(number);
		int remaining = numNodes - number;
//		System.out.println(remaining);

		return Math.abs(number - remaining);
	}
}
