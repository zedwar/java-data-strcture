package src.dataStructures.queen;

public class qunee {
    public static void main(String[] args) {

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
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列是空的");
        }
        front++;
        return arr[front];
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
    //显示头部数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("数据是空的");
        }
        return arr[front+1];
    }
}