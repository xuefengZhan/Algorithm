package _01_sort.cmp;

import _01_sort.Sort;

import java.util.Arrays;

//1945年由约翰·冯·诺伊曼（John von Neumann）首次提出。
//执行流程
//① 不断地将当前序列平均分割成 2 个子序列
//直到不能再分割（序列中只剩 1 个元素）
//② 不断地将 2 个子序列合并成一个有序序列
//直到最终只剩下 1 个有序序列
public class _08_MergeSort<T extends Comparable<T>> extends Sort<T> {


    private  void mergeSort(T[] arr,int low,int high){
        //1.边界
        if(arr == null || (low == high)) return;
        //2.关系
        int mid = (low+high) >> 1;

        mergeSort(arr,low,mid); //让左边有序

        mergeSort(arr,mid+1,high);//让右边有序


        merge(arr,low,mid,high); //合并左右

    }

    private  Object[] SubList(T[] arr,int low,int high){
        Object[] lowhigh = new Object[high-low+1];
        int x = 0;
        for(int i = low;i<=high;i++){
            lowhigh[x] = arr[i];
            x++;
        }
        return lowhigh;
    }


    private void merge(T[] arr,int low,int mid,int high){

        Object[] leftArray = SubList(arr, low, mid);

        int li=0;
        int ri = mid+1;
        int ai = low;
        while(ai<=high){
            if(li<leftArray.length && (ri > high || cmp((T)leftArray[li],arr[ri])<=0) ){
                arr[ai] = (T)leftArray[li];
                ai++;
                li++;
            }else{
                arr[ai] = arr[ri];
                ai++;
                ri++;
            }
        }
    }


    @Override
    protected void sort() {
        mergeSort(array,0,array.length-1);
    }
}
