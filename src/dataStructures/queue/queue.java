package src.dataStructures.queen;

import java.util.Scanner;

public class queue {
    public static void main(String[] args) {
    ArrayQueue Array = new ArrayQueue(3);
    char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e（exit）：退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看头数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    Array.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个值");
                    int value = scanner.nextInt();
                    Array.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res = Array.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                        Array.move();
                    }catch (Exception e){
                        //TODO:handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h'://查看队列头
                    try{
                        int res = Array.headQueue();
                        System.out.printf("队列头数据是%d\n",res);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }
    }
}
class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    //创建队列构造器

    public ArrayQueue(int arrMaxsize) {
        maxSize = arrMaxsize;
        arr = new int[maxSize];
        front = -1;//只想队列头部，front指向队列的前一个位置
        rear = -1;//指向队列尾的数据
    }
    //判断队列是否为满
    public boolean isFull(){
        return rear == maxSize-1;
    }
    //判断队列是否为满
    public boolean isEmpty(){
        return rear == front;
    }
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满，不能再添加数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }
    public void showQueue(){
        if (isEmpty()){
            System.out.println("数据已空，无法继续操作");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列是空的");
        }
        return(arr[front+1]);
    }
    //显示头部数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("数据是空的");
        }
        return arr[front+1];
    }
    public void move() {
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length-1] = 0;
        rear--;
    }
}