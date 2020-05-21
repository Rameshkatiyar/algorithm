package tech.dsa.graph;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Here we represent the graph in the form of adjacency-list.
 */
public class Graph {

    private Map<Vertex, List<Vertex>> adjacencyVertices;

    public Graph(){
        adjacencyVertices = new HashMap<>();
    }

    public List<Vertex> getAdjacencyVertices(String label){
        Optional<Vertex> vertexOptional = getVertexByLabel(label);
        if (!vertexOptional.isPresent()){
            return null;
        }
        return adjacencyVertices.get(vertexOptional.get());
    }

    public List<Vertex> getAllVertexOfGraph(){
        return adjacencyVertices.keySet().stream().collect(Collectors.toList());
    }

    public Boolean addEdge(String fromLabel, String toLabel, int weight){
        Optional<Vertex> fromVertexOptional = getVertexByLabel(fromLabel);
        Optional<Vertex> toVertexOptional = getVertexByLabel(toLabel);
        if (!fromVertexOptional.isPresent() || !toVertexOptional.isPresent()){
            System.out.print("Error - One of vertex is not exist.");
            return false;
        }

        Vertex fromVertex = fromVertexOptional.get();
        Vertex toVertex = toVertexOptional.get();
        toVertex.setWeight(weight);

        List<Vertex> vertices = adjacencyVertices.get(fromVertex);
        vertices.add(toVertex);

        return true;
    }

    public Boolean addVertex(String label){
        if (getVertexByLabel(label).isPresent()){
            System.out.print("Error - Vertex is already exist: "+ label);
            return false;
        }
        Vertex newVertex = new Vertex(label);
        adjacencyVertices.put(newVertex, new LinkedList<>());
        return true;
    }

    public Boolean removeVertex(String label){
        Optional<Vertex> vertexOptional = getVertexByLabel(label);
        if (vertexOptional.isPresent()){
            Vertex vertexToRemove = vertexOptional.get();
            adjacencyVertices.get(vertexToRemove).stream()
                    .forEach(
                            vertex -> adjacencyVertices.get(vertex).remove(vertexToRemove)
                    );
            adjacencyVertices.remove(vertexToRemove);
            return true;
        }
        return false;
    }

    public Optional<Vertex> getVertexByLabel(String label){
        Optional<Vertex> vertexOptional = adjacencyVertices.keySet().stream()
                .filter(
                        vertex -> vertex.getLabel().equalsIgnoreCase(label)
                ).findFirst();
        return vertexOptional;
    }

    public void printGraph(){
        adjacencyVertices.keySet().stream()
                .forEach(
                        vertex -> {
                            System.out.print("{"+vertex.getLabel()+"}");
                            adjacencyVertices.get(vertex).stream()
                                    .forEach(
                                            vertex1 -> System.out.print("--->["+vertex1.getLabel()+"]")
                                    );
                            System.out.println("");

                        }
                );
        System.out.println("");
    }
}
