package _02_UnionFInd;

public class QuickUnion extends UnionFind {


    public QuickUnion(int capacity) {
        super(capacity);
    }

    @Override
    //找到根节点
    public int find(int v) {
        rangeCheck(v);
        while (parents[v] != v) {
            v = parents[v];
        }
        return v;
    }


    //todo QuickUnion 就是将集合1中的根节点指向集合2的根节点
    @Override
    public void union(int v1, int v2) {
        //数组中元素是索引的根节点
        int p1 = find(v1);
        int p2 = find(v2);
        if(p1 == p2) return;

        parents[p1] = p2;
    }
}
