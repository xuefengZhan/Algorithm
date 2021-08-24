package _01_sort.cmp;

import _01_sort.Sort;

public class _01_Bubble_3<T extends Comparable<T>> extends Sort<T> {

    /**
     *  优化思路：
     *      记录下[0,end)最后一次交换的位置 index, [index,length-1]都是有序的
     *      从而实现从end-- 直接跳跃到 index
     *      减少循环次数
     */
    @Override
    protected void sort() {
        for (int i = array.length - 1; i > 0; i--) {

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