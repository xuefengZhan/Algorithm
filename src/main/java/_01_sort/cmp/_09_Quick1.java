package _01_sort.cmp;

import java.util.Arrays;

public class _09_Quick1 {
    public static void sort(int[] array){
        sort(array,0,array.length-1);
    }

    // step1:将序列拆成两半，左边比轴点元素小，右边比轴点元素大
    // step2:将左边序列拆成两半，左边比左边的轴点小，右边比右边的轴点大
    // step3:处理右边
    private static void sort(int[] array,int low,int high){
        if(low >= high) return;
        int mid = partition(array,low,high); //左边小 右边大于等于
        sort(array,low,mid-1);
        sort(array,mid+1,high);
    }

    private static int partition(int[] array,int low,int high){
        //指定轴点元素
        if(low == high) return low;

        int pivot = array[low];
        //lfet  [low,left -1]的所有元素< pivot
        //right [right,high]的所有元素 >= pivot
        int left = low+1;
        int right = high;

        while(right >= left ){
            //right 指向比pivot小的元素
            if(array[right] >= pivot){
                right--;
            }else{
                //array[right] < pivot
                if(array[left] < pivot){
                    left++;
                }else{
                    //array[left] >= pivot
                    int tmp = array[left];
                    array[left] = array[right];
                    array[right] = tmp;
                    left++;
                    right--;
                }
            }
        }
        //如果循环条件是right > left 的话当right ==left 的时候，不知道这个元素是比pivot大还是小，因此不能和array[low]交换
        //right == left -1    right是<pivot的    left >= pivot   所以用right交换
        array[low] = array[right];
        array[right] = pivot;
        return right;
    }

    public static void main(String[] args) {
        int[] arr = {26,15,23,48,54,2,35,9,20,36,71,32,37,65};

        _09_Quick1 sort = new _09_Quick1();
        sort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}

