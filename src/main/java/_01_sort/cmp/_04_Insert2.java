package _01_sort.cmp;

import _01_sort.Sort;

import java.util.Arrays;

public class _04_Insert2<T extends Comparable<T>>  extends Sort<T> {

//    @Override
//    protected void sort() {
//        for(int i = 1;i<array.length;i++){
//            T tmp = array[i];
//            int cur=i-1; // cur定义为 <= tmp的第一个元素
//            while(cur>=0 && cmp(array[cur],tmp)>0){
//                array[cur+1]=array[cur];
//                cur--;
//            }
//            //cur<0 或者 arr[cur]<= tmp
//            array[cur+1] = tmp;
//        }
//    }

    //不挨个交换，找到目标位置index 将(index,end)的元素全部后移
    @Override
    protected void sort() {
        for(int end = 1;end < array.length;end++){
            T ele = array[end];
            for(int i = end -1;i>=0;i--){
                if(cmp(array[i],ele)>0){
                    array[i+1] = array[i];
                }else{
                    //ele >= array[i]
                    array[i+1] = ele;
                    break;
                }
            }
        }
    }

}
//稳定性： cmp <= 0 不稳定  <0稳定
