package tech.dsa.graph;

public class VertexWeight {
    String label;
    int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public VertexWeight(String label, int weight){
        this.label = label;
        this.weight = weight;
    }

}
