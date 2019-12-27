package src.dataStructures.LinkedList;

public class DoubleLinkedList02 {
    public static void main(String[] args) {
        //双向链表的测试
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "如均已", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "无用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
    //创建双向链表对象
        DoublelinkedList doublelinkedList = new DoublelinkedList();
        doublelinkedList.add(hero1);
        doublelinkedList.add(hero2);
        doublelinkedList.add(hero3);
        doublelinkedList.add(hero4);
        doublelinkedList.list();
        HeroNode2 newHeroNode = new HeroNode2(4,"公孙胜","入云龙");
        doublelinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doublelinkedList.list();
//删除数据
        doublelinkedList.del(2);
        doublelinkedList.list();

    }
}
class DoublelinkedList {
    //初始化头结点
    public HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }
    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while(true){
            //判断是否到链表最后
            if(temp ==null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移，
            temp=temp.next;
        }
    }
//添加数据到最后
    public void add(HeroNode2 heroNode){
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while(true){
            //找到链表的最后
            if(temp.next == null){
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当推出while循环是，temp就指向了链表的最后
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    //修改数据，可以看到和单向链表结果一致
    public void update(HeroNode2 heroNode){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while(true){
            if (temp == null){
                break;//已经遍历完链表
            }
            if(temp.no == heroNode.no){
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        }else{
            //没有找到
            System.out.printf("没有找到编号%d的节点，不能修改\n",heroNode.no);
        }
    }
    //删除数据
    public void del(int no){
        //判断当前链表为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;//标志是否已找到删除节点的
        while(true){
            if(temp == null){
                //已经到链表的最后
                break;
            }
            if(temp.no == no){
                //找到的代删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            //temp.next = temp.next.next;
            temp.pre.next = temp.next;
            //如果是最后一个节点就不需要执行下面这句话，否则会出现空指针异常
            if (temp.next!=null){
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.printf("要删除的节点%d不存在",no);
        }
    }
}




class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;
    //构造器
    public HeroNode2(int hNo,String name,String nickname){
        this.no = hNo;
        this.name = name;
        this.nickname = nickname;
    }
//为了显示方法，重写tostring方法

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
