package src.dataStructures.LinkedList;

public class CircleLinkedList {
    public static void main(String[] args) {
        //测试
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(25);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1,5,25);
    }
}

//创建环形的单向链表
class CircleSingleLinkedList{
    //创建一个first节点，当前没有编号
    public Boy first = null;
    public void addBoy(int nums){
        //nums做一个数据校验
        if(nums<1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针，帮助构建环形链表
        //使用for循环来创建我们的环形链表
        for (int i = 1; i < nums+1; i++) {
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1){
                first = boy;
                first.setNext(first);//构成环
                curBoy = first;//让curBoy指向第一个小孩
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }
    //遍历当前环形链表
    public void showBoy(){
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;
        while(true){
            System.out.printf("小孩的编号%d\n",curBoy.getNo());
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
    //根据用户的输入，计算出小孩出圈的顺序
    /**
     *
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums 表示最初有几个小孩
     */
    public void countBoy(int startNo,int countNum,int nums){
        //先对数据进行检验
        if(first == null || startNo<1||startNo>nums){
            System.out.println("输入数据有误，请重新输入");
            return;
        }
        Boy helper = first;
        //创建一个辅助指针，帮助小孩出圈
        while(true){
            if (helper.getNext()==first){
                break;
            }
            helper = helper.getNext();
        }
        for (int j = 0; j < startNo-1; j++) {
            first=first.getNext();
            helper=helper.getNext();
        }
        while(true){
            if (helper == first){
                break;
            }
            for (int j = 0; j < countNum-1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d\n",helper.getNo());
    }
}


//定义小孩节点
class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}