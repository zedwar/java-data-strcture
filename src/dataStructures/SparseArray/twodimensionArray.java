package src.dataStructures.SparseArray;

public class twodimensionArray {
    public static void main(String[] args) {
        //首先创建一个稀疏数组
        int sparesArray[][] = new int[4][3];
        sparesArray[0][0] = 10;
        sparesArray[0][1] = 7;
        sparesArray[0][2] = 3;
        sparesArray[1][0] = 2;
        sparesArray[1][1] = 4;
        sparesArray[1][2] = 1;
        sparesArray[2][0] = 4;
        sparesArray[2][1] = 5;
        sparesArray[2][2] = 2;
        sparesArray[3][0] = 6;
        sparesArray[3][1] = 7;
        sparesArray[3][2] = 1;
        System.out.println("打印原始的稀疏数组");
        for (int i = 0; i < sparesArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparesArray[i][0],sparesArray[i][1],sparesArray[i][2]);
        }
        System.out.println();
        int twodimension[][] = new int[sparesArray[0][0]][sparesArray[0][1]];
        for (int[] row:sparesArray) {
            if (row != sparesArray[0]) {
                twodimension[row[0]-1][row[1]-1] = row[2];
            }
        }
        //输出二维数组
        for (int[] row : twodimension) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
