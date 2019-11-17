package LeepCode._191117;

/**
 * @Author DreamYee
 * @Create 2019/11/17  8:32
 */
/*请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
现有一个链表 -- head = [4,5,1,9]，它可以表示为:
*/
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }

    public static void main(String[] args) {
        DeleteNode dn=new DeleteNode();
        ListNode node1=new ListNode(4);
        ListNode node2=new ListNode(5);
        ListNode node3=new ListNode(1);
        ListNode node4=new ListNode(9);

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
