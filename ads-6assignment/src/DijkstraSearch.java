import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    public DijkstraSearch(WeightedGraph<V> graph) {
        super(graph);
    }

    @Override
    public void performSearch(Vertex<V> startVertex) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> predecessors = new HashMap<>();
        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        for (Vertex<V> vertex : graph.getVertices()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(startVertex, 0.0);

        priorityQueue.add(startVertex);

        while (!priorityQueue.isEmpty()) {
            Vertex<V> currentVertex = priorityQueue.poll();

            for (Edge<V> edge : graph.getEdges(currentVertex)) {
                Vertex<V> neighbor = edge.getDest();
                double weight = edge.getWeight();

                double newDistance = distances.get(currentVertex) + weight;

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    predecessors.put(neighbor, currentVertex);
                    priorityQueue.remove(neighbor);
                    priorityQueue.add(neighbor);
                }
            }
        }

        for (Vertex<V> vertex : graph.getVertices()) {
            System.out.print("Shortest path to " + vertex.getData() + ": ");
            if (distances.get(vertex) == Double.POSITIVE_INFINITY) {
                System.out.println("No path");
            } else {
                List<Vertex<V>> path = new ArrayList<>();
                Vertex<V> current = vertex;

                while (current != null) {
                    path.add(current);
                    current = predecessors.get(current);
                }

                Collections.reverse(path);

                for (int i = 0; i < path.size(); i++) {
                    System.out.print(path.get(i).getData());
                    if (i != path.size() - 1) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println(" (Distance: " + distances.get(vertex) + ")");
            }
        }
    }
}
