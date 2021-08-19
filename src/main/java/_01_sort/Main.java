package _01_sort;

import _01_sort.cmp.*;
import _01_sort.tools.Asserts;
import _01_sort.tools.Integers;

import java.util.Arrays;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Main {
    // 在 main 函数里写测试代码
    public static void main(String[] args) {
        /*
            count:测试的数据量
            min:最小值
            max:最大值
         */
        Integer[] array = Integers.random(20000, 1, 10000);
//        Integer[] array = Integers.random(10, 1, 100);
//
//        new _03_HeapSort().sort(array);
//        Integers.println(array);

        // 在这里面写要测试的代码
        testSorts(array,
                new _01_Bubble(),
                new _01_Bubble_2(),
                new _01_Bubble_3(),
                new _02_Select()
//                new _03_HeapSort(),
//                new _04_Insert(),
//                new _04_Insert2(),
//                new _07_Insert_BinarySearch(),
//                new _08_MergeSort()
        );
    }

    // 下面这个复制就可以
    static void testSorts(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }
        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }

}