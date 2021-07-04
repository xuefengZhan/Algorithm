package _01_sort.cmp;

import _01_sort.Sort;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class _04_Insert<T extends Comparable<T>>  extends Sort<T> {

    @Override
    protected void sort() {
        for(int i = 1;i<array.length;i++){
            for(int j = i;j>0;j--){
                if(cmp(array[j],array[j-1])<0){
                    swap(j,j-1);
                }else{
                    break;
                }

            }
        }
    }

    private static int[] arr = {35,57,23,12,45,12,46,23,68,34,326,19,35,26,27};
    public static void sort(int[] arr){
        for(int i = 1;i<arr.length;i++){
            for(int j = i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }else{
                    break;
                }

            }
        }
    }

    //优化：挪动
    public static void sort2(int[] arr){
        for(int i = 1;i<arr.length;i++){
            int tmp = arr[i];
            int cur=i-1; // cur定义为 <= tmp的第一个元素
            while(cur>=0 && arr[cur]>tmp){
                arr[cur+1]=arr[cur];
                cur--;
            }
            //cur<0 或者 arr[cur]<= tmp
            arr[cur+1] = tmp;
        }
    }

    public static void main(String[] args) {
        _04_Insert.sort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
//稳定性： cmp <= 0 不稳定  <0稳定
//