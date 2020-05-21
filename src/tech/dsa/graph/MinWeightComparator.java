package tech.dsa.graph;

import java.util.Comparator;

public class MinWeightComparator implements Comparator<VertexWeight> {
    @Override
    public int compare(VertexWeight o1, VertexWeight o2) {
        if (o1.weight > o2.weight ){
            return 1;
        }else{
            return -1;
        }
    }
}
