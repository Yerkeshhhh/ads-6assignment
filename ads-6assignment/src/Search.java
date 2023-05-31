public class Search<V> {
    public WeightedGraph<V> graph;

    public Search(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    public void performSearch(Vertex<V> startVertex) {

        BreadthFirstSearch<V> bfs = new BreadthFirstSearch<>(graph);
        bfs.performSearch(startVertex);

        DijkstraSearch<V> dijkstra = new DijkstraSearch<>(graph);
        dijkstra.performSearch(startVertex);

    }
}
