package DataStructures.pro0917CircleLinkedList;


/**
 * @Author DreamYee
 * @Create 2019/09/17  16:46
 */
public class Josephu {
    public static void main(String[] args) {
        //测试
        CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        //小孩出圈
        circleSingleLinkedList.countBoy(1,2,5);//2->4->1->5->3

    }

}

//创建一个环形的单向链表
class CircleSingleLinkedList{
    //创建一个first节点，当前没有编号
    private Boy first=new Boy(-1);
    //添加小孩节点，构建一个环形链表
    public void addBoy(int nums){
        //nums做一个数据校验
        if(nums<1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy=null;//辅助指针，帮助构建环形链表
        //使用for来创建环形链表
        for(int i=1;i<=nums;i++){
            //根据编号创建小孩节点
            Boy boy=new Boy(i);
            //如果是第一个小孩
            if(i==1){
                first=boy;
                first.setNext(first);//构成环
                curBoy=first;//让curBoy指向第一个小孩
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }

    //遍历当前链表环形链表
    public void showBoy(){
        //是否为空链表
        if(first==null){
            System.out.println("链表为空！");
            return;
        }
        //因为first不能动，因此使用辅助指针完成遍历
        Boy curBoy=first;
        while (true){
            System.out.printf("小孩的编号%d\n",curBoy.getNo());
            if(curBoy.getNext()==first){//说明遍历完毕
                break;
            }
            curBoy=curBoy.getNext();//curBoy后移
        }
    }

    //根据用户的输入，计算出出圈的一个顺序

    /**
     *
     * @param startNo   表示从第几个小孩开始数数
     * @param countNum  表示数几下
     * @param nums      表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){
        //先对数据进行校验
        if(first==null||startNo<1||startNo>nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建一个辅助指针，帮助小孩出圈
         Boy helper=first;
        while (true){
            if(helper.getNext()==first){//说明helper指向最后
                break;
            }
            helper=helper.getNext();
        }
        //小孩报数前，先让first和helper移动startNo-1次
        for(int j=0;j<startNo-1;j++){
            first=first.getNext();
            helper=helper.getNext();
        }
        //当报数时，让first和helper移动countNum-1次
        //这里是循环操作,直到圈中只有一个节点
        while (true){
            if(helper==first){//说明只有一个节点
                break;
            }
            //否则让first跟helper同时移动countNum-1次
            for(int j=0;j<countNum-1;j++){
                first=first.getNext();
                helper=helper.getNext();
            }
            //
            System.out.printf("小孩%d出圈\t",first.getNo());
            //将first指向的小孩节点出圈
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号:%d\n",first.getNo());

    }
}

//先创建一个boy类，表示一个节点
class Boy{
    private int no;//编号
    private Boy next;//指向下一个节点，默认为null
    public Boy(int no){
        this.no=no;
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
