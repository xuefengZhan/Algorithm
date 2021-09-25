package _02_UnionFInd;

public class QuickUnion_Size extends QuickUnion{
    //todo 1.基于Size，优化quick union
    // 维护当前节点作为集合根节点中集合元素个数
    private int size[];

    public QuickUnion_Size(int capacity) {
        super(capacity);
        //默认每个元素集合中有一个元素
        size = new int[capacity];
        for (int i = 0; i < size.length; i++) {
            size[i] = 1;
        }
    }


    @Override
    public void union(int v1, int v2) {

        int p1 = find(v1);
        int p2 = find(v2);
        if(p1 == p2) return;

        //把小的集合放进大的集合
        if(size[p1] < size[p2]){
            parents[p1] =p2;
            size[p2] += size[p1];
        }else{
            parents[p2] =p1;
            size[p1] += size[p2];
        }

    }
}
