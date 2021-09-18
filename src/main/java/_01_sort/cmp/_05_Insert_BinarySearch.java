package _01_sort.cmp;

import _01_sort.Sort;

public class _05_Insert_BinarySearch<T extends Comparable<T>> extends Sort<T> {

    private int searchIndex(T[]array,T v){
        return searchIndex(array,v,0,array.length-1);
    }


    private int searchIndex(T[] array,T v,int low,int high){
        if(array == null || array.length == 0) return -1;

        int mid;
        while(high > low){
            mid  = (high + low )>>1;
            if(array[mid] == v){
                return mid;
            }else if(cmp(array[mid] ,v)>0){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        //到这里说明 high = low
        if(cmp(array[low],v)>0){  //如果这里改为>= 就不是稳定排序了
            return low;
        }else{
            return low+1;
        }
    }

    @Override
    protected void sort() {
        for (int i = 1; i < array.length; i++) {
            //[0,i)是有序区域    arr[i] 是待插元素
            T tmp = array[i];
            int insertIndex = searchIndex(array, tmp,0,i-1);  //logN
            //将[insertIndex,i-1]范围内的有序元素 往后移动1位
            for(int j = i;j>insertIndex;j--){
                array[j] = array[j-1];
            }//n
            //将元素插进去
            array[insertIndex] = tmp;
        }
    }
    // n*(n+logN) => 因此时间复杂度还是O(n平方)  只不过优化了搜索 索引的位置
}
