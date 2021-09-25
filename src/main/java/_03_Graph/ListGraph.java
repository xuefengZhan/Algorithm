package _03_Graph;

import java.util.*;

public class ListGraph<V,E> implements Graph<V,E>{

    private Map<V,Vertex<V,E>> vertices = new HashMap<>();
    private Set<Edge<V,E>> edges = new HashSet<>();//存放所有的边

    public void print(){
        vertices.forEach((V v,Vertex<V,E> vertext)->{
            System.out.println(v);
        }
    );
        edges.forEach(System.out::println);

    }



    @Override
    public int edgeSize() {
        return edges.size();
    }

    @Override
    public int verticesSize() {
        return vertices.size();
    }

    @Override
    public void addVertex(V v) {
       if(vertices.containsKey(v)) return;
        vertices.put(v,new Vertex<>(v));
    }

    /**
     * 添加无权值的边
     */
    @Override
    public void addEdge(V from, V to) {
        addEdge(from, to, null);
    }

    /*
     * 添加有权值的边
     */
    @Override
    public void addEdge(V from, V to, E weight) {
        // 根据传入的参数from找到出发点,如果不存在则创建
        Vertex<V, E> fromVertex = vertices.get(from);
        if(fromVertex == null){
            fromVertex = new Vertex<>(from);
            vertices.put(from, fromVertex);
        }
        // 根据传入的参数to找到终点,如果不存在则创建
        Vertex<V, E> toVertex = vertices.get(to);
        if(toVertex == null){
            toVertex = new Vertex<>(to);
            vertices.put(to, toVertex);
        }

        // 根据出发点与终点,创建边
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        edge.weight = weight; // 有权值则加上权值,无权值则为null

        // 不管原来是否存在,都先删除此边,再添加进去
        if(fromVertex.outEdges.remove(edge)){
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
        fromVertex.outEdges.add(edge);
        toVertex.inEdges.add(edge);
        edges.add(edge);
    }


    @Override
    public void removeVertex(V v) {

    }

    @Override
    public void removeEdge(V from, V to) {

    }

    //顶点
    /**
     * 顶点
     */
    private static class Vertex<V, E> {
        V value;
        Set<Edge<V, E>> inEdges = new HashSet<>(); // 进来的边
        Set<Edge<V, E>> outEdges = new HashSet<>(); // 出去的边
        public Vertex(V value){
            this.value = value;
        }
        @Override
        public boolean equals(Object obj) {
            return Objects.equals(value, ((Vertex<V, E>)obj).value);
        }
        @Override
        public int hashCode() {
            return value == null ? 0 : value.hashCode();
        }

        @Override
        public String toString() {
            return value == null ? "null" : value.toString();
        }
    }


    //边
    private static class Edge<V, E> {
        Vertex<V, E> from; // 出发点
        Vertex<V, E> to; // 到达点
        E weight;	// 权值

        public Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
        }
        @Override
        public boolean equals(Object obj) {
            Edge<V, E> edge = (Edge<V, E>) obj;
            return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }
        @Override
        public int hashCode() {
            return from.hashCode() * 31 + to.hashCode();
        }
        @Override
        public String toString() {
            return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
        }

    }



}
