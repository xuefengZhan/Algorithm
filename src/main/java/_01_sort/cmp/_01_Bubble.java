package _01_sort.cmp;

import _01_sort.Sort;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

//最坏、平均时间复杂度： n平方
//最好时间复杂度： o(n)
//空间复杂度： O(1)
//冒泡排序属于 In-place
//冒泡排序属于稳定的排序算法
// 不稳定的写法：
//  arr[j]>=arr[j+1]

public class _01_Bubble <T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (cmp(array[j], array[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }

    }
}
