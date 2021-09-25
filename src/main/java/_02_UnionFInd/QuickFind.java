package _02_UnionFInd;

public class QuickFind extends UnionFind{
    @Override
    public int find(int v) {
        rangeCheck(v);
        return parents[v];
    }


    //todo quickFind 操作 在union的时候，将集合1的所有元素都放进集合2中
    @Override
    public void union(int v1, int v2) {

        int p1 = parents[v1];
        int p2 = parents[v2];
        if(p1==p2) return;

        for (int i = 0; i < parents.length; i++) {
            if(parents[i] == p1){
                parents[i] = p2;
            }
        }
    }

    public QuickFind(int capacity) {
        super(capacity);
    }
}
