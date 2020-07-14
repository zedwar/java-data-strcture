package src.dataStructures.recursion;

public class Queen8 {
    //定义一个max表示共有几个皇后
    int max = 8;
    //定义数组，来保存八皇后纺织的结果
    int[] array = new int[max];
    static int count = 0;
    static int judgecount = 0;
    public static void main(String[] args) {
        //测试八皇后是否正确
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d解法",count);
        System.out.printf("一共冲突的次数%d次",judgecount);
    }
    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经拜访的皇后冲突
    //特别注意，check是每一次递归时，都有一个for循环，因此会有回溯
    private void check(int n){
        if(n==max){
            print();
            return;
        }
        //依次放入皇后
        for (int i = 0; i < max; i++) {
            //先把当前的皇后该行的第一列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)){//说明不冲突
                //接着放n+1个皇后，即开始递归
                check(n+1);
            }
            //如果冲突，就继续执行array[n] = i；即将第n个皇后放置在本行的后移的一个位置
        }
    }

    /**
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n){
        judgecount++;
        for (int i = 0; i < n; i++) {
            //1.前面判断是否同一列，后面判断是否在同一斜线
            if(array[i] == array[n]||Math.abs(n-i)==Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    //写一个方法，将皇后摆放的位置输出
    private void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
