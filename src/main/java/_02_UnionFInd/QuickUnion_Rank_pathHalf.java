package _02_UnionFInd;

public class QuickUnion_Rank_pathHalf extends QuickUnion_Rank{

    public QuickUnion_Rank_pathHalf(int capacity) {
        super(capacity);
    }


    //路径减半
    //rank基础上，在find寻找根节点的过程中，隔一个节点指向祖父节点
    @Override
    public int find(int v) {
        rangeCheck(v);

        while(parents[v] !=v ){
            parents[v] = parents[parents[v]];
            v = parents[v];
        }
        return parents[v];
    }
}
