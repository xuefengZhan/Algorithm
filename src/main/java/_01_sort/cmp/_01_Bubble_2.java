package _01_sort.cmp;

import _01_sort.Sort;

public class _01_Bubble_2 <T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int i = array.length - 1; i > 0; i--) {

            int exchange = 0;
            for (int j = 0; j < i; j++) {
                if (cmp(array[j], array[j + 1]) > 0) {
                    swap(j, j + 1);
                    exchange++;
                }
            }
            if (exchange == 0) break;

        }


    }
}