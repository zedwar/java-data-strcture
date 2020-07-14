package src.dataStructures.Sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {101,34,109,1};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);

    }
    //选择排序
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = 1+i; j < arr.length; j++) {
                if(min>arr[j]){
                    min = arr[j];//重置min
                    minIndex = j;//重置minIndex
                }
            }
            if (minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第"+(i+1)+"轮后");
            System.out.println(Arrays.toString(arr));
        }

    }
}
