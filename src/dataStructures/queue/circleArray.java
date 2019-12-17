package src.dataStructures.queue;

import java.util.Scanner;

public class circleArray {
    public static void main(String[] args) {
        System.out.println("测试代码");
        CircleArr Array = new CircleArr(4);
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

class CircleArr{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    public CircleArr(int arrMaxsize) {
        maxSize = arrMaxsize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }
    //判断队列是否为满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    //判断队列是否为kong
    public boolean isEmpty(){
        return rear == front;
    }
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满，不能再添加数据");
            return;
        }
        arr[rear] = n;
        rear =(rear+1)%maxSize;
    }
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列是空的");
        }
        //这里需要分析胡front是指向队列的第一个元素
        //先把front对应的值保存，然后再后裔
        //将保存的量返回
        int value =arr[front];
        front = (front+1)%maxSize;
        return value;
    }
    public void showQueue(){
        if (isEmpty()){
            System.out.println("数据已空，无法继续操作");
            return;
        }
        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d] = %d\n",i%maxSize,arr[i%maxSize]);
        }
    }
    public int size(){
        return(rear + maxSize-front)%maxSize;
    }
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("数据是空的");
        }
        return arr[front];
    }
}