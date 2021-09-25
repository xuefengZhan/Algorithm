package _02_UnionFInd;

public class QuickUnion_Rank extends QuickUnion{
    //todo 1.维护当前节点的高度
    private int ranks[];

    public QuickUnion_Rank(int capacity) {
        super(capacity);
        ranks = new int[capacity];
        for (int i = 0; i < ranks.length; i++) {
            ranks[i] = 1;
        }
    }


    //基于高度的union 将矮的集合放进高的集合
    @Override
    public void union(int v1, int v2) {

        int p1 = find(v1);
        int p2 = find(v2);
        if(p1 == p2) return;


        //矮的加进去不需要修改树高
       if(ranks[p1] < ranks[p2]){
           parents[p1] = p2;
       }else if(ranks[p1] > ranks[p2]){
           parents[p2] = p1;
       }else{
           //树一样高
           parents[p1] = p2;
           ranks[p2] += 1;
       }


    }
}
