package _01_sort.cmp;

import _01_sort.Sort;

public class _01_Bubble_3<T extends Comparable<T>> extends Sort<T> {

    //
    @Override
    protected void sort() {
        for (int i = array.length - 1; i > 0; i--) {
            //这里end的定义为： [end,array.length-1]范围内的元素是有序的
            //记录最后一次交换的位置， 那么这个位置到最后都是有序的
            int end = 1;
            for(int j = 0;j< i;j++){
                if(cmp(array[j], array[j + 1]) > 0){
                    swap(j,j+1);
                    end=j+1;
                }
            }
            i = end;
        }


    }
}