package _02_UnionFInd;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GenericUnionFind<V> {

    //节点元素
    private static class Node<V> {
        V value;
        Node<V> parent = this;
        int rank = 1;
        Node(V value) {
            this.value = value;
        }
    }

    //todo 1.用于存储所有节点
    private Map<V, Node<V>> nodes = new HashMap<>();

    //todo 2.用于将对象放进集合中
    public void makeSet(V v){
        if(nodes.containsKey(v)) return;
        nodes.put(v, new Node<>(v));
    }

    /**
     * 找出v的根结点
     */
    private Node<V> findNode(V v){
        Node<V> node = nodes.get(v);
        if(node == null) return null;
        while(!Objects.equals(node.value, node.parent.value)){
            node.parent = node.parent.parent;
            node = node.parent;
        }
        return node;
    }

    public V find(V v) {
        Node<V> node = findNode(v);
        return node == null ? null : node.value;
    }


    //合并两个集合
    public void union(V v1, V v2){
        Node<V> p1 = findNode(v1);
        Node<V> p2 = findNode(v2);
        if(p1 == null || p2 == null) return;
        if (Objects.equals(p1.value, p2.value)) return;

        if(p1.rank < p2.rank){
            p1.parent = p2;
        }else if(p1.rank > p2.rank){
            p2.parent = p1;
        }else{
            p1.parent = p2;
            p1.rank += 1;
        }
    }
    public boolean isSame(V v1, V v2){
        return Objects.equals(find(v1), find(v2));
    }



}
