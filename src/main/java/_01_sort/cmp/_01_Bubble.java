package _01_sort.cmp;

import _01_sort.Sort;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class _01_Bubble<T extends Comparable<T>> extends Sort<T> {
    /**
     * end的定义为：[0,end]范围内 最大元素 待放置位置；一轮循环下来后，[0,end]的最大元素就放在end位置了；
     * 如此在完成当前轮排序前：[0,end]是无序的， (end,length-1]是有序的
     * 完成当前轮排序后：[0,end）是无序的， [end,length-1]是有序的
     */
    @Override
    public void sort() {
//        for(int end = array.length -1; end> 0;end--){
//            for(int cur = 0;cur < end;cur++){
//                if(cmp(array[cur] , array[cur+1]) > 0){
//                    swap(cur,cur+1);
//                }
//            }
//        }
//    }
        for (int end = array.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                }
            }
        }
    }
}

