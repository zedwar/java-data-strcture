package src.dataStructures.Stack;

public class Calculator {
    public static void main(String[] args) {
        //根据前面老师的思路，完成表达式的运算
        String expression = "3+2*6-2";
        //创建两个栈，数栈，一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack  = new ArrayStack2(10);
        //定义需要的变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch =' ';//扫面得到的char保存到ch
        String keepNum = "";//用于拼接多位数
        while(true){
            ch = expression.substring(index,index+1).charAt(0);
            if(operStack.isOper(ch)){
                //判断当前的符号栈是否为空
                if(!operStack.isEmpty()){
                    if(operStack.priority(ch)<= operStack.priority(operStack.peek())){
                        num2 = numStack.pop();
                        num1 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else{
                        operStack.push(ch);
                    }
                }else{
                    //如果为空直接存入符号栈
                    operStack.push(ch);
                }
            }else{
                //处理多位数
                keepNum += ch;
                //如果ch是最近一位，则直接入栈
                if (index==expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        //清空keepNum
                        keepNum = "";
                    }
                }
            }
            //让index+1，并判断是否扫描到expression
            index++;
            if (index>=expression.length()){
                break;
            }
        }
        //当扫描完毕，就顺序的从两个栈中探出数据进行计算
        while(true){
            //如果符号栈为空，则计算到最后的结果
            if (operStack.isEmpty()){
                break;
            }
            num2 = numStack.pop();
            num1 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.printf("表达式%s = %d",expression,numStack.pop());
    }
}
class ArrayStack2{
    private int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟栈，数据就放在该数组
    private int top = -1;//表示栈顶，初始化为-1


    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    //返回栈顶值
    public int peek(){
        return stack[top];
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
    //返回运算符的优先级，优先级是程序员来确定，优先级使用数字表示
    //数字越大，则优先级越高
    public int priority(int oper){
        if (oper == '*'||oper =='/'){
            return 1;
        }else if(oper == '+'||oper == '-'){
            return 0;
        }else{
            return -1;//假定目前的表达式只有+-*/
        }
    }

    public boolean isOper(char val){
        return val == '+'||val =='-'||val =='*'||val == '/';
    }
    //计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;//res 用于存放计算的结果
        switch(oper){
            case '+':
                res = num1+num2;
                break;
            case '-':
                res = num1-num2;
                break;
            case '*':
                res = num1*num2;
                break;
            case '/':
                res = num2/num1;
                break;
            default:
                break;
        }
        return res;
    }
}