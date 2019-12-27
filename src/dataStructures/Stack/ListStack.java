package src.dataStructures.Stack;

import java.util.Scanner;

public class ListStack {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while(loop){
            System.out.println("s:表示显示栈");
            System.out.println("e:退出程序");
            System.out.println("push:表示添加数据到栈（入栈）");
            System.out.println("pop:表示从栈取出数据（出栈）");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case"s":
                    stack.list();
                    break;
                case"push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case"pop":
                    try{
                        int res = stack.pop();
                        System.out.printf("出栈的数据是%d\n",res);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case"exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
            System.out.println("退出程序");
        }
    }
}

//定义一个栈结构
class ArrayStack{
    private int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟栈，数据就放在该数组
    private int top = -1;//表示栈顶，初始化为-1

    //构造器

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize-1;
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈-push
    public void push(int value){
        //先判断栈是否满
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈操作，将栈顶的数据返回
    public int pop(){
        //先判断是否为空
        if (isEmpty()){
            //抛出异常
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //显示栈的情况（遍历栈），遍历时，需要从栈顶显示数据
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top; i > 0; i--) {
            System.out.printf("第%d个数据为%d\n",(top-i+1),stack[i]);
        }
    }
}