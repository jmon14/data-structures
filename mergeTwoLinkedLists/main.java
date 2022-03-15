// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
    ListNode<Integer> iter;
    ListNode<Integer> head = new ListNode(0);
    if (l1 == null) {
        head.next = l2;
    } else if (l2 == null) {
        head.next = l1;
    } else {
        iter = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                iter.next = l2;
                iter = iter.next;
                l2 = l2.next;
            } else if (l2 == null) {
                iter.next = l1;
                iter = iter.next;
                l1 = l1.next;
            } else if (l1.value > l2.value) {
                iter.next = l2;
                iter = iter.next;
                l2 = l2.next;
            } else if (l2.value > l1.value || (l2.value - l1.value) == 0 ) {
                iter.next = l1;
                iter = iter.next;
                l1 = l1.next;                
            }
        }
    }
    return head.next;
}
