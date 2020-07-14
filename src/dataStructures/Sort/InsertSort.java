package src.dataStructures.Sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int [] arr ={101,34,119,1};
        insertSort(arr);
    }
    public  static void insertSort(int[] arr){
        //使用逐步推导的方式来讲解
        //写入待插入的数
        for (int i = 0; i < arr.length; i++) {

            int insertVal = arr[i];
            int insertIndex = i- 1;//即arr【1】的前面这个数的下标
            //给insertVal找到插入的位置
            //insertIndex>=0保证插入位置不越界
            //insertVal<arr[insertIndex]待插入的数还没有找到插入的位置
            //需要将arr【insertIndex】后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到了
            //判断是否需要赋值
            if (insertIndex+1==i){
                arr[insertIndex + 1] = insertVal;
            }
            System.out.println("第"+i+"轮插入");
            System.out.println(Arrays.toString(arr));
        }

        //第二轮
        /*insertVal = arr[2];
        insertIndex = 2-1;
        while(insertIndex>=0&&insertVal<arr[insertIndex]){
            arr[insertIndex+1]=arr[insertIndex];
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到了
        arr[insertIndex+1] = insertVal;
        System.out.println("第2轮插入");
        System.out.println(Arrays.toString(arr));*/
    }
}
