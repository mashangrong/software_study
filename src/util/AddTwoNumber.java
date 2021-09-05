package util;

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int sum = 0;
        int more = 0;
        while (l1 != null || l2 != null || more > 0) {
            sum = (l1 == null ? 0 : l1.val) +  (l2 == null ? 0 : l2.val) + more;
            more = sum / 10;
            sum = sum % 10;
            ListNode tmp = new ListNode(sum);
            cur.next = tmp;
            cur = tmp;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}
