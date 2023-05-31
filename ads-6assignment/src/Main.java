public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> vertexA = new Vertex<>("L");
        Vertex<String> vertexB = new Vertex<>("O");
        Vertex<String> vertexC = new Vertex<>("V");
        Vertex<String> vertexD = new Vertex<>("E");

        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);

        graph.addEdge(vertexA, vertexB, 5.0);
        graph.addEdge(vertexA, vertexC, 3.0);
        graph.addEdge(vertexB, vertexD, 2.0);
        graph.addEdge(vertexC, vertexD, 4.0);

        Search<String> search = new BreadthFirstSearch<>(graph);

        search.performSearch(vertexA);
    }
}