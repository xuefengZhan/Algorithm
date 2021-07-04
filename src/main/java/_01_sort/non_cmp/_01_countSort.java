package _01_sort.non_cmp;

import _01_sort.Sort;

public class _01_countSort extends Sort<Integer> {
    /**
     * 计数排序最简单的实例
     */
    private void sort0(){
        // 找出最大值
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        // 根据最大值来开辟内存空间
        int[] counts = new int[max + 1];
        // 统计每个整数出现的次数
        for(int i = 0; i < array.length; i++){
            counts[array[i]]++;
        }
        // 根据整数出现的次数，对整数进行排序
        int index = 0;
        for(int i = 0; i < counts.length; i++){
            while(counts[i]-- > 0){
                array[index++] = i;
            }
        }
    }


    @Override
    protected void sort() {

    }
}
