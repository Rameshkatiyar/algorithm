package tech.dsa.graph;

import java.util.*;

public class DijkastraAlgo {
    public static void main(String[] args) {
        Graph graph = getGraphExample();
//        BFSTraversing.traverse(graph, "1");

        Map<String, VertexWeight> labelVertexMap = new HashMap<>();

        //1. Initilize the priority queue with infinity.
        Queue<VertexWeight> priorityQueue = new PriorityQueue<>(graph.getAllVertexOfGraph().size(), new MinWeightComparator());
        graph.getAllVertexOfGraph().stream()
                .filter(
                        vertex -> !vertex.getLabel().equalsIgnoreCase("1")
                )
                .forEach(
                        vertex ->{

                            VertexWeight vertexWeight = new VertexWeight(vertex.getLabel(), Integer.MAX_VALUE);
                            labelVertexMap.put(vertex.getLabel(), vertexWeight);
                            priorityQueue.add(vertexWeight);
                        }

                );

        VertexWeight source = new VertexWeight("1", 0);
        labelVertexMap.put("1", source);
        priorityQueue.add(source);

        while (!priorityQueue.isEmpty()){
            VertexWeight vertex = priorityQueue.remove();
            System.out.print(vertex.getLabel()+" --> ");

            List<Vertex> adjacencyVertices = graph.getAdjacencyVertices(vertex.getLabel());
            adjacencyVertices.stream()
                    .forEach(
                            ver -> {
                                String label = ver.getLabel();
                                VertexWeight vertexWeight = labelVertexMap.get(label);
                                priorityQueue.remove(vertexWeight);
                                int minWeight = getMin(vertex.getWeight()+ver.getWeight(), vertexWeight.getWeight());

                                vertexWeight.setWeight(minWeight);
                                priorityQueue.add(vertexWeight);
                            }
                    );

        }



    }

    public static int getMin(Integer w1, Integer w2){
        if (w1 < w2)
            return w1;
        else
            return w2;
    }

    public static Graph getGraphExample(){
        Graph graph = new Graph();

        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");

        graph.addEdge("1", "2", 2);
        graph.addEdge("1", "3", 4);

        graph.addEdge("2", "4", 7);
        graph.addEdge("2", "3", 1);

        graph.addEdge("3", "5", 3);

        graph.addEdge("4", "6", 1);

        graph.addEdge("5", "4", 2);
        graph.addEdge("5", "6", 5);

        return graph;
    }
}
