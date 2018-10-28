package answers;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private int distance;
    private List<Integer> visited;

    public Path() {
        distance = 0;
        visited = new ArrayList<>();
        visited.add(0);
    }

    public Path(Path path, int newNode, int amount) {
        distance = path.getDistance();
        visited = path.getVisited();
        addNode(newNode, amount);
    }

    public Path(int distance) {
        this.distance = distance;
    }

    public List<Integer> getVisited() {
        return visited;
    }

    public int getDistance() {
        return distance;
    }

    public void addNode(int visit, int amount) {
        visited.add(visit);
        distance += amount;
    }
}
