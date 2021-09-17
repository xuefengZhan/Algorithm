package _01_sort.cmp;

import _01_sort.Sort;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class _04_Insert<T extends Comparable<T>> extends Sort<T> {


    //交换
    @Override
    protected void sort() {
        for (int end = 1; end < array.length; end++) {
           for(int i = end;i>0;i--){
               if(cmp(array[i],array[i-1])<0){
                   swap(i,i-1);
               }else{
                   break;
               }
           }
        }
    }
}
//稳定性： cmp <= 0 不稳定  <0稳定
