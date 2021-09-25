package _02_UnionFInd;

public class QuickUnion_Rank_pathCompress extends QuickUnion_Rank{

    public QuickUnion_Rank_pathCompress(int capacity) {
        super(capacity);
    }


    //路径压缩
    //rank基础上，在find寻找根节点的过程中，将所有节点直接指向根节点
    @Override
    public int find(int v) {
        rangeCheck(v);
        if(parents[v] !=v ){
            parents[v] = find(parents[v]);
        }
        return parents[v];
    }
}
