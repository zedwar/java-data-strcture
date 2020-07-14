package src.dataStructures.Sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort2(arr);
    }
    //使用逐步推导的方法进行排序
    public static void shellSort(int[] arr){
        int temp = 0;
        int count =0;
        for (int gap = arr.length/2;gap>0;gap/=2){
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素（共5组，每组有两个元素）步长5
                for (int j = i-gap; j >=0; j-=gap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j]>arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
            System.out.println("排序"+(++count)+"轮之后"+ Arrays.toString(arr));
        }
        //希尔排序的第1轮排序，
        //第一轮排序，是将10个数据分成了5组


        /*//希尔排序的第2轮排序，
        //第一轮排序，是将10个数据分成了5/2=2组
        for (int i = 2; i < arr.length; i++) {
            //遍历各组中所有的元素（共5组，每组有两个元素）步长5
            for (int j = i-2; j >=0; j-=2) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j]>arr[j+2]){
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }
        System.out.println("排序2轮之后"+ Arrays.toString(arr));

        //希尔排序的第3轮排序，
        //第一轮排序，是将10个数据分成了2/2=1组
        for (int i = 1; i < arr.length; i++) {
            //遍历各组中所有的元素（共5组，每组有两个元素）步长5
            for (int j = i-1; j >=0; j-=1) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("排序3轮之后"+ Arrays.toString(arr));*/
        }
    public static void shellSort2(int[] arr){
        //增量gap，并逐步的缩小增量
        int count = 0;
        for (int gap = arr.length; gap >0; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                int j=i;
                int temp = arr[j];
                if(arr[j]<arr[j-gap]){
                    while(j-gap>=0&&temp<arr[j-gap]){
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }
            }
            System.out.println("排序"+(++count)+"轮之后"+ Arrays.toString(arr));
        }
    }
}
