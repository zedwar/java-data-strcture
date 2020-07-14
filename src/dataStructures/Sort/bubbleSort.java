package src.dataStructures.Sort;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int arr[] = {-1,-2,3,9,10};
        //第一趟排序，就是将最大的数据排在最后
        int temp = 0;//临时变量
        boolean flag = false;
        for (int j = 1; j < arr.length-1; j++) {
            for (int i = 0; i < arr.length-1-j; i++) {
                if (arr[i]>arr[i+1]){
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            System.out.printf("第%d趟排序的结果",j);
            System.out.println(Arrays.toString(arr));
            if (!flag){
                break;
            }else{
                flag = false;
            }
        }

/*          //第二趟排序
        for (int i = 0; i < arr.length-1-1; i++) {
            if (arr[i]>arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第二趟排序的结果");
        System.out.println(Arrays.toString(arr));*/
    }
}
