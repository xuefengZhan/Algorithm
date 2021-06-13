package _01_sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class _04_Insert {

    int[] arr = {26,15,23,48,654,2,35,489,320,546,21,32,48,65};

    private void swap(int[] arr,int i ,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //插入排序的稳定写法： arr[j]<arr[j-1]
    //最坏、平均时间复杂度：n平方
    //最好时间复杂度：O(n)
    //空间复杂度：O(1)
    //属于稳定排序
    //当逆序对的数量极少时，插入排序的效率特别高
    //甚至速度比 O(nlogn) 级别的快速排序还要快
    //数据量不是特别大的时候，插入排序的效率也是非常好的。
    @Test
    public void insert(){
        for (int i = 1; i <= arr.length-1; i++) {
            for(int j = i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
            }
        }
    }





    @After
    public void end(){
        System.out.println(Arrays.toString(arr));
    }
}

