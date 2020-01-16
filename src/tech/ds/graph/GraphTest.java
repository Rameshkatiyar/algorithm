package tech.ds.graph;

public class GraphTest {

    public static void main(String args[]){
        Graph graph = getGraphExample2();
        graph.printGraph();
        graph.removeVertex("2");
        graph.printGraph();
    }

    public static Graph getGraphExample1(){
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "H", 1);
        graph.addEdge("B", "A", 1);
        graph.addEdge("C", "B", 1);
        graph.addEdge("C", "E", 1);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "C", 1);
        graph.addEdge("H", "B", 1);
        graph.addEdge("H", "E", 1);
        graph.addEdge("E", "C", 1);
        graph.addEdge("E", "H", 1);
        graph.addEdge("E", "F", 1);
        graph.addEdge("E", "G", 1);
        graph.addEdge("G", "E", 1);
        graph.addEdge("F", "E", 1);
        return graph;
    }

    public static Graph getGraphExample2(){
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
