package _01_sort.cmp;

import _01_sort.Sort;

public class _01_Bubble_2 <T extends Comparable<T>> extends Sort<T> {

    /**
     *  优化思路1：
     *   [0,end] 是乱序的  (end,length-1] 是有序的
     *   如果 cur 在遍历[0,end)的过程中，没有发生swap(cur,cur+1)操作，表示[0,end]数据是有序的
     *   此时，end不需要 end-- 迭代了,直接结束程序
     */
    @Override
    public void sort() {
        for(int end = array.length -1; end> 0;end--){

            boolean sorted = true;
            for(int cur = 0;cur < end;cur++){
                if(cmp(array[cur] , array[cur+1]) > 0){
                    swap(cur,cur+1);
                    sorted = false;
                }
            }
            if(sorted) break;
        }
    }
}