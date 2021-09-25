package _03_Graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface Graph<V,E> {

    //边个数
    int edgeSize();

    int verticesSize();

    //添加顶点
    void addVertex(V v);

    void addEdge(V from ,V to);

    void addEdge(V from,V to,E weight);

    void removeVertex(V v);

    void removeEdge(V from,V to);

}
