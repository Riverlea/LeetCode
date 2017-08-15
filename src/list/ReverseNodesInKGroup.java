package list;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/15 16:45
 */

public class ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for (ListNode prev = dummy , end = head; end != null; end = prev.next) {
            for (int i = 1; i < k && end != null; ++i) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            prev = reverse(prev, prev.next, end);
        }

        return dummy.next;

    }

    private static ListNode reverse(ListNode prev, ListNode begin, ListNode end) {
        ListNode end_next = end.next;
        for(ListNode p = begin, cur = p.next, next = cur.next;
                cur != end_next;
                p = cur, cur = next, next = next != null ? next.next : null) {
            cur.next = p;
        }
        begin.next = end_next;
        prev.next = end;
        return begin;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.createList(new int[]{1,2,3,4,5,6,7});
        ListNode.printList(reverseKGroup(listNode, 3));
    }
}
