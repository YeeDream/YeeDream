package DataStructures.pro0916DoubleLinkedList;

/**
 * @Author DreamYee
 * @Create 2019/09/16  20:06
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        System.out.println("双向链表的测试");
        //先创建节点
        HeroNode2 hero1=new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2=new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3=new HeroNode2(3,"吴用","智多星");
        HeroNode2 hero4=new HeroNode2(4,"林冲","豹子头");
        //创建一个双向链表
        DoubleLinkedList doubleLinkedList=new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        //修改
        HeroNode2 newHeroNode=new HeroNode2(4,"公孙胜","入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改之后的表情况");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表情况");
        doubleLinkedList.list();
    }
}

//创建一个双向链表的类
class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表
    public void list() {
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将next后移
            temp = temp.next;
        }
    }

    //添加一个节点到双向链表的最后
    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，因此需要一个辅助遍历temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true) {
            //遍历链表，找到最后
            if (temp.next == null) {
                break;
            } else {
                //如果没有找到最后，就将temp后移
                temp = temp.next;
            }
        }
        //当退出while循环时，temp就指向了链表的最后
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre=temp;
    }

    //修改一个节点的内容，双向链表与单向链表一样
    //只是节点类型改为HeroNode2
    public void update(HeroNode2 newHeroNode){
        //判断是否空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode2 temp=head.next;
        boolean flag=false;
        while(true){
            if(temp==null){
                break;//已经遍历完链表了
            }
            if(temp.no==newHeroNode.no){
                //找到
                flag=true;
                break;
            }
            temp=temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if(flag){
            temp.name=newHeroNode.name;
            temp.nickname=newHeroNode.nickname;
        }else {//没有找到
            System.out.printf("没有找到编号%d的节点，不能修改\n",newHeroNode.no);
        }
    }
    //从双向链表中删除一个节点
    //说明
    //1.对于双向链表可以直接找到要删除的这个节点
    //找到后自我删除即可
    public void del(int no) {
        //判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;//标志是否找到待删除节点的
        while (true) {
            if (temp == null) {//已经到链表的最后
                break;
            }
            if (temp.no == no) {
                //找到待删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;//temp后移
        }
        //判断flag
        if (flag) {//找到
            //可以删除
            //temp.next=temp.next.next;[单向链表]
            temp.pre.next = temp.next;
            //代码有问题
            //如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            //temp.next=null.pre
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的%d节点不存在\n", no);
        }
    }
}

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个节点,默认为null
    public HeroNode2 pre;//指向前一个节点，默认为null

    //构造器
    public HeroNode2(int hNo,String hName,String hNickname){
        this.no=hNo;
        this.name=hName;
        this.nickname=hNickname;
    }

    //为了显示方便，我们重新toString

    @Override
    public String toString() {
        return "HeroNode[" +
                "no=" + no +
                ", name=" + name  +
                ", nickname=" + nickname  +
                ']';
    }
}

