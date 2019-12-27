package src.dataStructures.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {

        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println(infixExpressionList);
        List<String> suffixExpression = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式的对应的List"+suffixExpression);
        System.out.printf("expression = %d",calculate(suffixExpression));
        //先定义一个逆波兰表达式
        //(3+4)*5-6 -->34+5*6-
        //为了方便，表达式中的数字和符号使用空格隔开
//        String suffixExpression = "3 4 + 5 * 6 -";
//        //先存入ArrayList中
//        //遍历ArrayList配合栈完成计算
//        List<String> rpnList =getListString(suffixExpression);
//        System.out.println("rpnList="+rpnList);
//        int res = calculate(rpnList);
//        System.out.println("计算的结果是 = "+res);
    }



    //将一个逆波兰表达式，一次将数据和计算符存放到ArrayList中
    public static List<String> getListString(String suffixExpression){
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String ele:split){
            list.add(ele);
        }
        return list;
    }
    //方法：将中缀表达式转成相应的list
    public static List<String> toInfixExpressionList(String s){
        //定义一个List，存放中缀表达式对应的内容
        List<String> ls = new ArrayList<String>();
        int i = 0;
        String str;
        char c;
        do{//如果c非数字，我们将需要加入到ls
            if ((c = s.charAt(i))<48||(c = s.charAt(i))>57){
                ls.add(""+c);
                i++;//i需要后移
            }else{
                //如果是一个数，需要考虑多位数
                str = "";
                while(i < s.length()&&(c = s.charAt(i))>48&&(c = s.charAt(i))<57){
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }while(i < s.length());
        return ls;
    }
    //将中缀表达式转换为后缀表达式
    public static  List<String> parseSuffixExpressionList(List<String> ls){
        Stack<String> s1 = new Stack<String>();
        ArrayList<String> s2 = new ArrayList<String>();
        for(String item:ls){
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else{
                //当item的优先级小于等于栈顶运算符的优先级，将s1栈顶的运算符弹出并加入到s2中
                while(s1.size()!=0&&Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }
        //将s1中剩余的运算符依次弹出并加入s2
        while(s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }
    //完成对逆波兰表达式的计算
    /*

     */
    public static int calculate(List<String>ls){
        //创建栈，只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        for (String item:ls){
            if(item.matches("\\d+")){
                stack.push(item);
            }else{
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res = num1+num2;
                }else if(item.equals("-")){
                    res = num1-num2;
                }else if (item.equals("*")){
                    res = num1*num2;
                }else if(item.equals("/")){
                    res = num1/num2;
                }else{
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push(res+"");
            }
        }
        //最后留在栈中的就是运算结果
        return Integer.parseInt(stack.pop());
    }

}


//编写一个类返回运算符对应的优先级
class Operation{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=2;
    public static int getValue(String operation){
        int result = 0;
        switch(operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}