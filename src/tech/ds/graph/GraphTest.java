package tech.ds.graph;

public class GraphTest {

    public static void main(String args[]){
        Graph graph = createTestGraph();
        graph.printGraph();
        graph.removeVertex("2");
        graph.printGraph();
    }

    private static Graph createTestGraph() {
        Graph graph = new Graph();

        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");

        graph.addEdge("1", "2", 1);
        graph.addEdge("1", "5", 1);
        graph.addEdge("2", "1", 1);
        graph.addEdge("2", "5", 1);
        graph.addEdge("2", "4", 1);
        graph.addEdge("2", "3", 1);
        graph.addEdge("3", "2", 1);
        graph.addEdge("3", "4", 1);
        graph.addEdge("4", "2", 1);
        graph.addEdge("4", "5", 1);
        graph.addEdge("4", "3", 1);
        graph.addEdge("5", "4", 1);
        graph.addEdge("5", "1", 1);
        graph.addEdge("5", "2", 1);
        return graph;
    }


}
