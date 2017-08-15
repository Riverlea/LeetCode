package list;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/8/13 18:09
 */



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    static ListNode createList(int[] arrays) {
        ListNode head = new ListNode(arrays[0]);
        ListNode temp = head;
        for(int i = 1; i < arrays.length; i++) {
            ListNode node = new ListNode(arrays[i]);
            temp.next = node;
            node.next = null;
            temp = node;
        }
        return head;
    }

    static void printList(ListNode listNode) {
        while(listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}


public class AddTwoNumbers {
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = l1.val + l2.val;
        ListNode head = new ListNode(flag % 10);
        ListNode result = head;
        while(l1.next != null || l2.next != null) {
            if(l1.next != null && l2.next != null) {
                l1 = l1.next;
                l2 = l2.next;
                flag = l1.val + l2.val + flag / 10;
                ListNode node = new ListNode(flag % 10);
                head.next = node;
                head = node;
            }
            else if(l1.next == null && l2.next != null) {
                l2 = l2.next;
                flag = l2.val + flag/10;
                ListNode node = new ListNode(flag % 10);
                head.next = node;
                head = node;
            }
            else {
                l1 = l1.next;
                flag = l1.val + flag/10;
                ListNode node = new ListNode(flag % 10);
                head.next = node;
                head = node;
            }
        }
        if(flag > 9) {
            ListNode node = new ListNode(1);
            head.next = node;
        }
        return result;
    }





    static ListNode createBack(ListNode listNode) {
        ListNode result = new ListNode(listNode.val);
        result.next = null;
        while(listNode.next != null) {
            listNode = listNode.next;
            ListNode temp = new ListNode(listNode.val);
            temp.next = result;
            result = temp;
        }
        return result;
    }


    public static void main(String[] args) {
        ListNode l1 = ListNode.createList(new int[]{5});
        ListNode l2 = ListNode.createList(new int[]{5});


        ListNode.printList(l1);
        ListNode.printList(l2);
        ListNode.printList(createBack(l1));
        System.out.println();
        ListNode. printList(addTwoNumbers(l1, l2));
    }
}
