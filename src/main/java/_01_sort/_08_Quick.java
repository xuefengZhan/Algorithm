package _01_sort;

import java.util.Arrays;

public class _08_Quick {

    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //功能：左边小于等于  arr[0]  右边> arr[0]
    private int Sort(int[] arr,int low,int high){
        int pivot = arr[low];

        //left指向 比pivot小的元素 该存放的位置，这意味着[low,left-1]全是小于pivot的元素
        //right 指向 比pivot大的元素该存放的位置  [right+1,high] 全是大于pivot的元素
        if(low == high) return low;
        int left = low+1;
        int right = high;

        //left++ 和right--的次数一共为 high-low次
        for (int i = low+1; i <= high; i++) {
            if(arr[i] <= pivot){
                swap(arr,left,i);
                left++;
            }else{
                swap(arr,i,right);
                right--;
            }
            if(left > right){
                break;
            }
        }
        //right = left -1
        swap(arr,low,right);
        return right;
    }

    //1.功能： 将arr的[low,high]部分变的有序
    public void quickSort(int[] arr,int low,int high){
        //2.边界
        if(low - high <= 0) return;

        //3.关系
        int mid = Sort(arr, low, high);
        quickSort(arr,low,mid-1);
        quickSort(arr,mid+1,high);
    }

    public static void main(String[] args) {
        int[] arr = {26,15,23,48,54,2,35,9,20,36,71,32,37,65};

        _08_Quick sort = new _08_Quick();
        System.out.println(sort.Sort(arr, 0, arr.length - 1));
        //sort.quickSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}
