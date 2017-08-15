package list;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/15 15:16
 */

public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    private static ListNode partion(ListNode[] lists, int s, int e) {
        if (s == e) {
            return lists[s];
        }
        if (s < e) {
            int q = (s + e) / 2;
            ListNode l1 = partion(lists, s, q);
            ListNode l2 = partion(lists, q + 1, e);
            return mergeTwoLists(l1, l2);
        } else {
            return null;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        for (ListNode p = head; l1 != null || l2 != null; p = p.next) {
            int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (val1 > val2) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = ListNode.createList(new int[]{1, 3, 6});
        listNodes[1] = ListNode.createList(new int[]{2, 4, 7});
        listNodes[2] = ListNode.createList(new int[]{5, 8, 9});
        ListNode.printList( mergeKLists(listNodes));
    }
}
