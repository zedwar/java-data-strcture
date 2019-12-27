package src.dataStructures.LinkedList;
//约瑟夫环（约瑟夫问题）是一个数学的应用问题：
// 已知n个人（以编号1，2，3...n分别表示）围坐在一张圆桌周围。
// 从编号为k的人开始报数，数到m的那个人出列；
// 他的下一个人又从1开始报数，数到m的那个人又出列；
// 依此规律重复下去，直到圆桌周围的人全部出列。
public class LinkedList02Josepfu {
    public static void main(String[] args) {
        boyLinkedList a = new boyLinkedList();
        a.addBoyNode(15);
        System.out.println(a);

    }
}

//定义链表
class boyLinkedList{
    public boynode head = new boynode(0,"");
    public void addBoyNode(int number){
        boynode temp = head;
        for (int i = 0; i <number ; i++) {
            boynode newboy = new boynode(i,"name"+i);
            temp.next = newboy;
            temp = temp.next;
        }
    }
    public void deleteboy(int k,int m){


    }
}

class boynode{
    private int no;
    private String name;
    public boynode next;

    public boynode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "boynode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
