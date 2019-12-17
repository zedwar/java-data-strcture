package src.dataStructures.LinkedList;

public class LinkedList01 {
    public static void main(String[] args) {
//进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "如均已", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "无用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入第一个人物
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero4);
        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2,"XIAORU","XIAOXIAORU");
        singleLinkedList.update(newHeroNode);
        singleLinkedList.list();
        //测试删除
        singleLinkedList.del(1);
        singleLinkedList.list();

    }
}

//定义单链表
class SingleLinkedList{
    //先初始化一个头节点，头节点不动且不存放任何数据
    private HeroNode head = new HeroNode(0,"","");
    //添加节点到单向链表
    //当不考虑添加顺序时
    //1.找到当前链表的最后节点
    //2.将这个最后的节点指向新的节点
    public void add(HeroNode heroNode){
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
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
    }
    public void addByOrder(HeroNode heroNode){
        //因为头结点不能动，因此仍需要使用辅助指针
        //因为单链表，我们需要找到temp在添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//flag标志添加的编号是否存在，默认为false
        while(true){
            if(temp.next == null){
                //说明temp已经在链表的最后
                break;//
            }
            if(temp.next.no>heroNode.no){
                //位置找到，就在temp的后面插入
                break;
            }else if(temp.next.no == heroNode.no){
                //说明希望添加的heroNode已经有了
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;//后移，遍历当前链表
        }
        //判断flag的值
        if (flag){
            //不能添加，说明编号存在
            System.out.printf("说明添加的编号%d已经存在，不能添加\n",heroNode.no);
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    public void update(HeroNode heroNode){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
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
    //删除指定节点
    //思路
    //1需要next比较
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;//标志是否已找到删除节点的
        while(true){
            if(temp.next == null){
                //已经到链表的最后
                break;
            }
            if(temp.next.no == no){
                //找到的代删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.printf("要删除的节点%d不存在",no);
        }
    }
    //显示链表
    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
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
}


class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    //构造器
    public HeroNode(int hNo,String hName, String hNickname){
        this.no = hNo;
        this.name = hName;
        this.nickname = hNickname;
    }
//为了显示方法，重写tostring方法

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\''+
                '}';
    }
}