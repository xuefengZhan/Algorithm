package _01_sort.cmp;

import java.util.Arrays;

public class _06_插入排序二分搜索优化 {
    // todo
    // 由于插入排序是分为有序区 和 无序区域
    // 因此在插入元素的时候，可以先用二分搜索 找到 应该插入的有序区中的位置

    /*
        此方法用于返回v在array的位置
     */
    public static int searchIndex(int[] array,int v){
        return searchIndex(array,v,0,array.length-1);
    }

    //有序范围[low,high]
    private static int searchIndex(int[] array,int v,int low,int high){
        if(array == null || array.length == 0) return -1;
//        high = array.length-1;
//        low = 0;
        int mid;
        while(high > low){
            mid  = (high + low )>>1;
            if(array[mid] == v){
                return mid;
            }else if(array[mid] > v){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        //到这里说明 high = low
        if(array[low] >= v){
            return low;
        }else{
            return low+1;
        }
    }

    public static void insert(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //[0,i)是有序区域    arr[i] 是待插元素
            int tmp = arr[i];
            int insertIndex = searchIndex(arr, tmp,0,i-1);  //logN
            //将[insertIndex,i-1]范围内的有序元素 往后移动1位
            for(int j = i;j>insertIndex;j--){
                arr[j] = arr[j-1];
            }//n
            //将元素插进去
            arr[insertIndex] = tmp;
        }

        //搜索 logN+N
    }


    public static void main(String[] args) {
        int[] arr = {26,15,23,48,654,2,35,489,320,546,21,32,48,65};

        insert(arr);
        System.out.println(Arrays.toString(arr));
    }
}
//使用了二分搜索后，只是减少了比较次数，但插入排序的平均时间复杂度依然是 O(n2)
//
//        最坏、平均时间复杂度：O(n2)
//        最好时间复杂度：O(n)
//        空间复杂度：O(1)
//        属于稳定排序