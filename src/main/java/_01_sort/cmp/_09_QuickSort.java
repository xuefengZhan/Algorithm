package _01_sort.cmp;

import _01_sort.Sort;

import java.util.Arrays;

public class _09_QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        sort(array,0,array.length-1);
    }

    // step1:将序列拆成两半，左边比轴点元素小，右边比轴点元素大
    // step2:将左边序列拆成两半，左边比左边的轴点小，右边比右边的轴点大
    // step3:处理右边
    private void sort(T[] array,int low,int high){
        if(low >= high) return;
        int mid = partition(array,low,high); //左边小 右边大于等于
        sort(array,low,mid-1);
        sort(array,mid+1,high);
    }

    private int partition(T[] array,int low,int high){
        //指定轴点元素
        if(low == high) return low;

        T pivot = array[low];
        //lfet  [low,left -1]的所有元素< pivot
        //right [right,high]的所有元素 >= pivot
        int left = low+1;
        int right = high;

        while(right >= left ){
            //right 指向比pivot小的元素
            if(cmp(array[right],pivot)>=0){
                right--;
            }else{
                //array[right] < pivot
                if(cmp(array[left],pivot) < 0){
                    left++;
                }else{
                    //array[left] >= pivot
                    T tmp = array[left];
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

}

