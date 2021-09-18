package _01_sort.cmp;

import java.util.Arrays;

//1945年由约翰·冯·诺伊曼（John von Neumann）首次提出。
//执行流程
//① 不断地将当前序列平均分割成 2 个子序列
//直到不能再分割（序列中只剩 1 个元素）
//② 不断地将 2 个子序列合并成一个有序序列
//直到最终只剩下 1 个有序序列
public class _08_Merge1 {
    public static void mergeSort(int[] arr) {

        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low == high) return;
        int mid = (low + high) >> 1;
        //2. sort left
        mergeSort(arr, low, mid);
        //3. sort right
        mergeSort(arr, mid + 1, high);
        //4. merge
        merge(arr, low, mid, high);
    }

    private static int[] copyList(int[] arr, int start, int end) {
        int[] result = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            result[i - start] = arr[i];
        }
        return result;
    }


    private static void merge(int[] arr, int low, int mid, int high) {
        int left = 0;
        int right = 0;

        int[] leftArr = copyList(arr, low, mid);
        int leftLen = leftArr.length;
        int[] rightArr = copyList(arr, mid + 1, high);
        int rightLen = rightArr.length;

        for (int i = low; i <= high; i++) {
            if (left >= leftLen || right < rightLen && leftArr[left] >= rightArr[right]) {
                arr[i] = rightArr[right];
                right++;
            } else {
                //else if(right > high || left <= mid && arr[left] <= arr[right] )
                arr[i] = leftArr[left];
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {26, 15, 23, 48, 54, 2, 35, 9, 20, 36, 71, 32, 37, 65};

        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
