package algorithms.leecode;

/**
 * @description:
 * @date: 18:30 2021/3/25
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order82RemoveDuplicatesFromSortedList2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null){
                return head;
            }
            ListNode zero = new ListNode(0,head);
            ListNode cur = zero;
            while(cur.next!=null && cur.next.next!=null){
                if(cur.next.val == cur.next.next.val){
                    int x = cur.next.val;
                    while(cur.next!=null && cur.next.val==x){
                        cur.next = cur.next.next;
                    }
                }else{
                    cur = cur.next;
                }
            }
            return zero.next;
        }
    }
}
