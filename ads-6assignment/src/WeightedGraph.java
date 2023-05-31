import java.util.*;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Edge<V>>> map;

    public WeightedGraph() {
        this.map = new HashMap<>();
    }

    public void addVertex(Vertex<V> vertex) {
        map.put(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        Edge<V> edge = new Edge<>(source, dest, weight);
        map.get(source).add(edge);
    }

    public List<Edge<V>> getEdges(Vertex<V> vertex) {
        return map.get(vertex);
    }

    public Set<Vertex<V>> getVertices() {
        return map.keySet();
    }
}
