package DataStructures.pro0914链表;

/**
 * @Author DreamYee
 * @Create 2019/09/14  21:39
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        //先创建节点
        HeroNode hero1=new HeroNode(1,"宋江","及时雨");
        HeroNode hero2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3=new HeroNode(3,"吴用","智多星");
        HeroNode hero4=new HeroNode(4,"林冲","豹子头");

        //创建要给链表

        SingleLinkedList singleLinkedList=new SingleLinkedList();
        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);

        //显示
        singleLinkedList.list();
    }
}

//定义SingleLinkedList管理我们的英雄
class SingleLinkedList {
    //先初始化一个头节点，头节点不要动,不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点到单链表
    //思路：不考虑编号顺序时
    //1.找到当前节点的最后节点
    //2.将最后节点的next指向新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //遍历链表，找到最后
            if (temp.next == null) {
                break;
            } else {
                //如果没有找到，就将temp后移
                temp = temp.next;
            }
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next指向新的节点
        temp.next = heroNode;
    }

    //显示链表（遍历）
    public void list(){
        //先判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此需要一个辅助变量来遍历
        HeroNode temp=head.next;
        while(true){
            //判断是否到链表最后
            if(temp==null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将next后移
            temp=temp.next;
        }
    }
}

//定义HeroNode,每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    //构造器
    public HeroNode(int hNo,String hName,String hNickname){
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
                ", nickname='" + nickname  +
                ']';
    }
}
