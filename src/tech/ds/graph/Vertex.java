package tech.ds.graph;

public class Vertex {
    String label;
    Vertex edge;
    int weight;

    public Vertex(String label){
        this.label = label;
        this.weight = 0;
        this.edge = null;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Vertex getEdge() {
        return edge;
    }

    public void setEdge(Vertex edge) {
        this.edge = edge;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
