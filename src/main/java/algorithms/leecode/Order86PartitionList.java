package algorithms.leecode;

/**
 * @Author LynHB
 * @Description :
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 23:27 2021/1/3
 **/
public class Order86PartitionList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode last = new ListNode(0);
        ListNode lastHead = last;
        ListNode next = new ListNode(0);
        ListNode nextHead = next;
        while(head != null){
            if(head.val < x){
                last.next = head;
                last = head;
            }else{
                next.next = head;
                next = head;
            }
            head = head.next;
        }
        next.next = null;
        last.next = nextHead.next;
        return lastHead.next;

    }
}
