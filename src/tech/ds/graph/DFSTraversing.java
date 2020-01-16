package tech.ds.graph;

import java.util.*;

/**
 * DFS Complexity: O(V) + O(E) = O(V+E)
 */
public class DFSTraversing {

    private static Stack<String> vertexStack; //In DFS, we use the STACK (PUSH == Visited)
    private static Map<String, Boolean> visitedMap; //Mark the element as a visited or not.

    public static void traverse(Graph graph, String source){
        vertexStack = new Stack<>();
        visitedMap = new HashMap<>();
        String top = source;

        graph.getAllVertexOfGraph().stream()
                .forEach(
                        vertex -> visitedMap.put(vertex.getLabel(), false)
                );

        vertexStack.push(top);
        System.out.println("Visited: " + top);
        visitedMap.put(top, true);

        while (!vertexStack.isEmpty()){ //For number of V nodes. = O(V)

            List<Vertex> adjacencyVertices = graph.getAdjacencyVertices(top);
            String unvisitedVertex = getUnvisitedVertexFromAdjancy(adjacencyVertices); // For number of adjacency edges. = O(E)

            if (null != unvisitedVertex){
                vertexStack.push(unvisitedVertex);
                top = unvisitedVertex;
                visitedMap.put(top, true);
                System.out.println("Visited: " + top);
            }
            else {
                vertexStack.pop();
                if (vertexStack.size() > 0){
                    top = vertexStack.peek();
                }
            }
        }

    }

    private static String getUnvisitedVertexFromAdjancy(List<Vertex> adjacencyVertices){
        Optional<String> unvisitedVertexOptional = adjacencyVertices.stream()
                .map(v -> v.getLabel())
                .filter(v -> !visitedMap.get(v))
                .findFirst();

        if (unvisitedVertexOptional.isPresent()){
            return unvisitedVertexOptional.get();
        }
        return null;
    }

    public static void main(String args[]){
        Graph testGraph = createTestGraph();
        testGraph.printGraph();
        traverse(testGraph, "A");
    }

    public static Graph createTestGraph() {
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
}
