package _01_sort.cmp;

import java.util.Arrays;

public class _09_Quick {


    public int partition(int[] arr,int low,int high){
        int pivot = arr[low];

        //left指向 <= pivot的元素 该存放的位置，这意味着[low,left-1]全是小于pivot的元素
        //right 指向 比pivot大的元素该存放的位置  [right+1,high] 全是大于pivot的元素
        if(low == high) return low;
        int left = low+1;
        int right = high;

        //left++ 和right--的次数一共为 high-low次
        while(right >= left){
            if(arr[left] <= pivot){
                left++;
            }else{
                int tmp = arr[left];
                arr[left] =arr[right];
                arr[right] = tmp;
                right--;
            }
        }

        //right = left -1
        arr[low] = arr[right];
        arr[right] = pivot;
        return right;
    }



    //功能：左边小于等于  arr[0]  右边> arr[0]
    //mj的代码
    private int partition2(int[] arr,int low,int high) {
        int pivot = arr[low];
        //left指向 比pivot小的元素 该存放的位置，这意味着[low,left-1]全是小于pivot的元素
        //right 指向 比pivot大的元素该存放的位置  [right+1,high] 全是大于pivot的元素
        if (low == high) return low;

        int left = low;
        int right = high;

        while (right > left) {
            while (right > left) {
                if (arr[left] < pivot) {
                    left++;
                } else {
                    arr[right--] = arr[left];
                    break;
                }
            }
            while (right > left) {
                if (arr[right] >= pivot) {
                    right--;
                } else {
                    arr[left++] = arr[right];
                    break;
                }
            }
        }
        //left == right
        arr[left] = pivot;
        return left;
    }


    //1.功能： 将arr的[low,high]部分变的有序
    private void sort(int[] arr,int low,int high){
        //2.边界
        if(low >= high) return;

        //3.关系
        int partition = partition(arr, low, high);
        sort(arr,low,partition-1);
        sort(arr,partition+1,high);
    }

    public void sort(int[] arr){
        sort(arr,0,arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {26,15,23,48,54,2,35,9,20,36,71,32,37,65};

        _09_Quick sort = new _09_Quick();
        sort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}

