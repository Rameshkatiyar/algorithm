package tech.ds.graph;

import java.util.*;
import java.util.stream.Collectors;

/**
 * O(V+E)
 */
public class BFSTraversing {

    private static Queue<String> vertexQueue; //In BFS, we use the QUEUE
    private static Map<String, Boolean> visitedMap; //Mark the element as a visited or not.

    public static void traverse(Graph graph, String source){
        vertexQueue = new LinkedList<>();
        visitedMap = new HashMap<>();
        String top = source;

        graph.getAllVertexOfGraph().stream()
                .forEach(
                        vertex -> visitedMap.put(vertex.getLabel(), false)
                );

        vertexQueue.add(top);
        visitedMap.put(top, true);
        System.out.println("Visited: "+top);

        while (!vertexQueue.isEmpty()){ //O(V)
            top = vertexQueue.poll();
            List<Vertex> adjacencyVertices = graph.getAdjacencyVertices(top);

            getUnvisitedVertices(adjacencyVertices).stream()
                    .forEach(
                            v -> {
                                vertexQueue.add(v);
                                visitedMap.put(v, true);
                                System.out.println("Visited: "+v);
                            }
                    );

        }
    }

    public static List<String> getUnvisitedVertices(List<Vertex> adjacencyVertices){
        return adjacencyVertices.stream()
                .map(v -> v.getLabel())
                .filter(v -> !visitedMap.get(v))
                .collect(Collectors.toList());
    }

    public static void main(String args[]){
        Graph testGraph = GraphTest.getGraphExample1();
        testGraph.printGraph();
        traverse(testGraph, "A");
    }
}
