package list;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/15 15:58
 */

public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode result = p;
        while(p.next != null && p.next.next != null) {
            ListNode tmp1 = p.next.next.next;
            ListNode tmp2 = p.next.next;
            p.next.next = tmp1;
            tmp2.next = p.next;
            p.next = tmp2;
            p = p.next.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.createList(new int[] {1,7});
        ListNode.printList(swapPairs(listNode));
    }
}
