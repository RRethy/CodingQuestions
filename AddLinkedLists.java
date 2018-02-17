/**
 * You are given two non-empty linked lists representing two non-negative integers
 * The digits are stored in reverse order and each of their nodes contain a single digit
 * Add the two numbers and return it as a linked list
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddLinkedLists {
    public ListNode addTwoNumbersCore(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) return carry == 0 ? null : new ListNode(carry);
        
        int val1 = (l1 == null) ? 0 : l1.val;
        int val2 = (l2 == null) ? 0 : l2.val;
        ListNode nextL1 = (l1 == null) ? null : l1.next;
        ListNode nextL2 = (l2 == null) ? null : l2.next;
        
        int newVal = (val1 + val2 + carry) % 10;
        int newCarry = (val1 + val2 + carry) / 10;
        
        ListNode l = new ListNode(newVal);
        l.next = addTwoNumbersCore(nextL1, nextL2, newCarry);
        
        return l;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode((l1.val + l2.val) % 10);
        l.next = addTwoNumbersCore(l1.next, l2.next, (l1.val + l2.val) / 10);
        return l;
    }
}
