package _01_sort.cmp;

import _01_sort.Sort;

public class _03_HeapSort<T extends Comparable<T>> extends Sort<T> {

    private int heapSize; // 堆大小

    @Override
    protected void sort() {
        heapSize = array.length;
        for (int i = (heapSize - 2) >> 1; i >= 0; i--) {
            siftDown(i);
        }
        while (heapSize > 1) {
            // 交换堆顶元素和尾部元素
            swap(0, --heapSize);

            // 对0位置进行siftDown（恢复堆的性质）
            siftDown(0);
        }

    }


    public void siftDown(int index) {
        T old = array[index];
        while (index <= (heapSize - 2) >> 1) {
            int leftIndex = (index << 1) + 1;
            int rightIndex = leftIndex + 1;
            int maxIndex = leftIndex;

            if (index <= (heapSize - 3) >> 1) {//左右都有
                maxIndex = cmp(array[leftIndex], array[rightIndex]) > 0 ? leftIndex : rightIndex;
            }
            if (cmp(array[maxIndex], old) > 0) {
                array[index] = array[maxIndex];
                index = maxIndex;
            } else {
                break;
            }
        }
        array[index] = old;
    }
}

