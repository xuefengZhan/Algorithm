package _02_UnionFInd;

public class QuickUnion_Rank_pathSplit extends QuickUnion_Rank{

    public QuickUnion_Rank_pathSplit(int capacity) {
        super(capacity);
    }


    //路径分裂
    //rank基础上，在find寻找根节点的过程中，将所有节点指向其祖父节点
    @Override
    public int find(int v) {
        rangeCheck(v);

        while(parents[v] !=v ){
            int p = parents[v];
            parents[v] = parents[p];
            v = p;
        }
        return parents[v];
    }
}
