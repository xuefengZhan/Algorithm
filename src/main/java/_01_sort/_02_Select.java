package _01_sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
//选择排序的交换次数要远远少于冒泡排序，平均性能优于冒泡排序。
//最好、最坏、平均时间复杂度：n平方
//空间复杂度：O(1)
//选择排序属于不稳定排序
//选择排序是否还有优化的空间？
//使用堆来选择最大值，可以大大提高选择速度。

//选择排序可以稳定啊


public class _02_Select {
    Student[] students = new Student[6];
    int[] arr = {26,15,23,48,654,02,35,489,320,0546,21,32,48,65};
    @Before
    public void init(){
        students[0] = new Student(4,"男1");
        students[1] = new Student(5,"女1");
        students[2] = new Student(3,"女2");
        students[3] = new Student(2,"女3");
        students[4] = new Student(4,"男2");
        students[5] = new Student(1,"女4");
    }

    private void swap(Student[] arr,int i ,int j){
        Student tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void swap(int[] arr,int i ,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void select1(){

        for (int i = arr.length -1; i > 0; i--) {
           int maxIndex = 0;
           for(int j = 1;j<=i;j++){
               if(arr[j] > arr[maxIndex]){
                   maxIndex = j;
               }
           }
           swap(arr,maxIndex,i);
        }
    }

    @Test
    public void select2(){
        for (int i = students.length - 1; i > 0; i--) {
            int maxIndex = 0;
            for(int j = 1;j<=i;j++){
                if(students[j].compareTo(students[maxIndex])>= 0){
                    maxIndex = j;
                }
            }
            swap(students,maxIndex,i);
        }

    }



    @After
    public void end(){
        System.out.println(Arrays.toString(students));
    }
}

class Student implements Comparable<Student>{
    int score;
    String name;


    @Override
    public int compareTo(Student o) {
        return this.score - o.score;
    }

    public Student(int score, String name) {
        this.score = score;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}