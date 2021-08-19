package _01_sort.cmp;

import _01_sort.Sort;

public class _01_Bubble_2 <T extends Comparable<T>> extends Sort<T> {

    //优化1：
    @Override
    public void sort() {
        for(int end = array.length -1; end> 0;end--){
            //如果右边比左边大，就交换二者位置;如果没发生交换，表示在[0,end]范围是有序的，
            //如果有序了，那么后面的就不用再比较了
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