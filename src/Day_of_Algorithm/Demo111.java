package Day_of_Algorithm;

/**
 * @Author DreamYee
 * @Create 2019/11/23  9:34
 */
/*在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5*/
public class Demo111 {
    public ListNode deleteDuplication(ListNode pHead) {
        //如果只有一个元素或者没有元素则可以直接返回，也就是迭代结束的标志
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        //迭代过程处理重复的内容，然后继续迭代，参数是删除重复后的后一个节点
        //首先判断是否有重复
        if (pHead.val == pHead.next.val) {
            //有重复的话就一直判断
            ListNode node = pHead.next;
            //将所有重复的点忽略，直到连接到没有重复的点，也就是node
            while (node != null && node.val == pHead.val) {
                node = node.next;
            }
            //在循环中，一直调用node.next，再次迭代中的参数就是已经删除的重复的指针
            return deleteDuplication(node);
        }else {
            //如果没有重复，就让pHead的下一个节点继续迭代
            //指向去除重复的下一个节点
            pHead.next=deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public static void main(String[] args) {
        Demo111 listnode=new Demo111();
        ListNode pHead=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(3);
        ListNode node6=new ListNode(3);
        ListNode node7=new ListNode(5);
        pHead.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        System.out.println(listnode.deleteDuplication(pHead));


    }
}

 class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
