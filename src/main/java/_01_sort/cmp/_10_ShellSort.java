package _01_sort.cmp;

import java.util.ArrayList;
import java.util.Arrays;

public class _10_ShellSort {
    public static ArrayList<Integer> getSteps(int length){
        //10 gap = 5  [0,5] [1,6] [2,7] [3,8] [4,9]
        //11 gap = 5  [0,5,10] [1,6] [2,7] [3,8] [4,9]

        // 10 gap = 5/2 = 2  [0,2,4,6,8] [1,3,5,7,9]
        // 11 gap = 5/2 = 2  [0,2,4,6,8,10] [1,3,5,7,9]

        //10 gap = 2/2 = 1 [0,1,2,3,4,5,6,7,8,9,10]
        ArrayList<Integer> steps = new ArrayList<>();
        for(int gap = length/2;gap>=1;gap/=2){
            steps.add(gap);
        }
        return steps;
    }





    //todo 1.gap xulie


    public static void sort(int[] arr){



//        for(int gap = arr.length/2;gap>=1;gap=gap/2){
//            for(int i=0;i<gap;i++){
//                for(int j=i+gap;j<arr.length;j=j+gap){
//                    for(int k = j;k>=gap;k=k-gap){
//                        if(arr[k]<arr[k-gap]){
//                            int tmp = arr[k];
//                            arr[k] = arr[k-gap];
//                            arr[k-gap] = tmp;
//                        }
//                    }
//                }
//            }
//        }

        ArrayList<Integer> steps = getSteps(arr.length);
        for (Integer gap : steps) {
            for(int i=0;i<gap;i++){
                for(int j=i+gap;j<arr.length;j=j+gap){
                    for(int k = j;k>=gap;k=k-gap){
                        if(arr[k]<arr[k-gap]){
                            int tmp = arr[k];
                            arr[k] = arr[k-gap];
                            arr[k-gap] = tmp;
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {26,15,23,48,54,2,35,9,20,36,71,32,37,65};

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
