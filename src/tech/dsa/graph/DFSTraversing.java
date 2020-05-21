package tech.dsa.graph;

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
        Graph testGraph = GraphTest.getGraphExample1();
        testGraph.printGraph();
        traverse(testGraph, "A");
    }
}
