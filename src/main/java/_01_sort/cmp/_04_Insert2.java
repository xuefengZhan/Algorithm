package _01_sort.cmp;

import _01_sort.Sort;

import java.util.Arrays;

public class _04_Insert2<T extends Comparable<T>>  extends Sort<T> {

    @Override
    protected void sort() {
        for(int i = 1;i<array.length;i++){
            T tmp = array[i];
            int cur=i-1; // cur定义为 <= tmp的第一个元素
            while(cur>=0 && cmp(array[cur],tmp)>0){
                array[cur+1]=array[cur];
                cur--;
            }
            //cur<0 或者 arr[cur]<= tmp
            array[cur+1] = tmp;
        }
    }

}
//稳定性： cmp <= 0 不稳定  <0稳定
//