package _01_sort;

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

public class _01_Bubble {
    int[] arr;
    @Before
    public void init(){
        arr = new int[]{15,23,13,54,12,3,68,21,5,6};
    }

    private void swap(int[] arr,int i ,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void bubble1(){
        for (int i = arr.length-1; i > 0 ; i--) {
            for(int j = 0;j< i;j++){
               if(arr[j]>arr[j+1]){
                   swap(arr,j,j+1);
               }
            }
        }
    }

    //优化  当前一次 遍历 结束，发现没有产生交换则全部有序，后面就不用再排序了
    @Test
    public void bubble2(){

        for (int i = arr.length-1; i > 0 ; i--) {
            int exchange = 0;
            for(int j = 0;j< i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    exchange ++;
                }
            }
            if(exchange == 0) break;
        }
    }
    //记录最后一次交换位置  减少排序次数
    @Test
    public void bubble3(){
        //假设最后一次交换位置为1，也就是假设全部有序
        //如果产生交换就更新交换位置，记录最大的交换位置
        //然后下一次只交换到此位置-1的位置
        for (int i = arr.length-1; i > 0 ; i--) {
            int end = 1;
            for(int j = 0;j< i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    end=j+1;
                }
            }
            i = end;
        }
    }

    @After
    public void end(){
        System.out.println(Arrays.toString(arr));
    }
}
