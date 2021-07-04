package _01_sort.cmp;

import _01_sort.Sort;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
//选择排序的交换次数要远远少于冒泡排序，平均性能优于冒泡排序。
//最好、最坏、平均时间复杂度：n平方
//空间复杂度：O(1)
//选择排序属于不稳定排序
//选择排序是否还有优化的空间？
//使用堆来选择最大值，可以大大提高选择速度。

//选择排序可以稳定啊


public class _02_Select<T extends Comparable<T>> extends Sort<T> {

    @Test
    public void sort(){
        for (int i = array.length -1; i > 0; i--) {
           int maxIndex = 0;
           for(int j = 1;j<=i;j++){
               if(cmp(array[j],array[maxIndex])>0){
                   maxIndex = j;
               }
           }
           swap(maxIndex,i);
        }
    }
}

