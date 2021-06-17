package _01_sort;

import java.util.Arrays;

//1945年由约翰·冯·诺伊曼（John von Neumann）首次提出。
//执行流程
//① 不断地将当前序列平均分割成 2 个子序列
//直到不能再分割（序列中只剩 1 个元素）
//② 不断地将 2 个子序列合并成一个有序序列
//直到最终只剩下 1 个有序序列
public class _07_Merge {

      public static void mergeSort(int[] arr){
          mergeSort(arr,0,arr.length-1);
      }
    //功能：让数组arr在[low,high]范围内有序
    //关系：[low,high] 分裂为：[low,mid] [mid+1,high] 两个子序列  所以  mergeSort([low,high]) = 合并两个有序序列： mergeSort(low,mid) +  mergeSort([mid+1,high])
    //边界：high = low 只有一个元素的时候直接返回，因为已经有序了
    public static void mergeSort(int[] arr,int low,int high){
        //1.边界
        if(arr == null || (low == high)) return;
        //2.关系
        int mid = (low+high) >> 1;
//        System.out.println("从"+mid+"分裂");
        mergeSort(arr,low,mid); //让左边有序
//        System.out.println(low+"到"+mid+"有序了");
        mergeSort(arr,mid+1,high);//让右边有序
//        System.out.println(mid+1  + "到"+high+"有序了");


        merge(arr,low,mid,high); //合并左右

    }

    private static int[] SubList(int[] arr,int low,int high){
        int[] lowhigh = new int[high-low+1];
        int x = 0;
        for(int i = low;i<=high;i++){
            lowhigh[x] = arr[i];
            x++;
        }
        return lowhigh;
    }

//    private static void merge(int[] arr,int low,int mid,int high){
//
//        int[] leftArray = SubList(arr, low, mid);
//        int[] rightArray = SubList(arr, mid + 1, high);
//
//
//
//        int li=0;
//        int ri = 0;
//        int ai = low;
//        while(ai<=high){
//          if(ri< rightArray.length && li < leftArray.length){
//              if(rightArray[ri] <= leftArray[li]){
//                  arr[ai] = rightArray[ri];
//                  ai++;
//                  ri++;
//              }else {
//                  arr[ai] = leftArray[li];
//                  ai++;
//                  li++;
//              }
//          }else if(ri < rightArray.length && li >= leftArray.length){
//              arr[ai] = rightArray[ri];
//              ai++;
//              ri++;
//          }else if(ri >= rightArray.length && li < leftArray.length){
//              arr[ai] = leftArray[li];
//              ai++;
//              li++;
//          }else{
//              break;
//          }
//       }

    private static void merge(int[] arr,int low,int mid,int high){

        int[] leftArray = SubList(arr, low, mid);

        int li=0;
        int ri = mid+1;
        int ai = low;
        while(ai<=high){
            if(li<leftArray.length && (ri > high || leftArray[li] <= arr[ri])){
                arr[ai] = leftArray[li];
                ai++;
                li++;
            }else{
                arr[ai] = arr[ri];
                ai++;
                ri++;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {26,15,23,48,54,2,35,9,20,36,71,32,37,65};
//        int mid = (arr.length -1)>>1;
//        int[] left = SubList(arr, 0, mid);
//        int[] right = SubList(arr, mid + 1, arr.length - 1);
//
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));
         mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
