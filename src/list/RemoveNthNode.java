package list;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/15 14:23
 */

public class RemoveNthNode {
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 1;
        ListNode result = head;
        while(head.next != null) {
            ++length;
            head = head.next;
        }
        if(n == length) {
            return result.next;
        } else if (length == 1) {
            return null;
        } else {
            head = result;
            for(int i = 0; i < length - n - 1; ++i){
                head = head.next;
            }
            head.next = head.next.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{4});
        ListNode.printList(removeNthFromEnd(head,1));
    }
}
