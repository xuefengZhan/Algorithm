package _01_sort.cmp;

public class _05_BinarySearch {

   //此二分搜索方法用于寻找V在有序数组中的索引位置

    //todo 1.递归实现
    public static int search(int[] array, int v){
        if(array == null || array.length == 0) return -1;
        return search(array,v,0,array.length-1);
    }
    private static int search(int[] array,int v,int low,int high){
        int mid = (low+high)>>1;

        if(mid == high){
            if(array[low] <= v){
                return low+1;
            }else{
                return low;
            }
        }

        if(array[mid] > v){
            return search(array,v,low,mid-1);
        }else if(array[mid] < v){
            return search(array,v,mid+1,high);
        }else {
            return mid;
        }
    }


//    todo 2.迭代实现
    public static int search2(int[] array, int v){
        if(array == null || array.length == 0) return -1;
        int high = array.length-1;
        int low = 0;
        int mid;
        while(high > low){
            mid  = (high + low )>>1;
            if(array[mid] == v){
                return mid;
            }else if(array[mid] > v){
                high = mid - 1; //high = low 那么 low位置<V
            }else{
                low = mid + 1;  //high = low 那么 low位置>V
            }
        }
        //到这里说明 high = low
        if(array[low] >= v){
            return low;
        }else{
            return low+1;
        }
    }


//    public static int Search(int[] array,int goal){
//        if(array == null || array.length == 0) return -1;
//        int high = array.length -1 ;
//        int low = 0;
//
//        while(high > low){
//            int mid = (high + low) >> 1;
//            if(array[mid] > goal){
//                high = mid -1;
//            }else if(array[mid] < goal){
//                low = mid + 1;
//            }else{
//                return mid;
//            }
//        }
//        //high == low
//        if(array[low] < goal) return low + 1;
//        else return low;
//    }
//
    public static int Search2(int[] array,int goal){
        if(array == null || array.length == 0) return -1;
        int high = array.length -1 ;
        int low = 0;

        return Ser(array,goal,high,low);
    }

    private static int Ser(int[] array,int goal,int high,int low){
        int mid = (high + low) >> 1;

        if(mid == high){
            return array[mid] >= goal ? mid : mid + 1;
        }

        if(goal > array[mid]){
            return Ser(array,goal,high,mid + 1);
        }else if(goal < array[mid]){
            return Ser(array,goal,mid -1 ,low);
        }else{
            return mid;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,4,5,8,12,23,25,46,68,78};
        int result = Search2(arr,13);
        System.out.println(result);
        System.out.println(search2(arr,5));
    }
}
