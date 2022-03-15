// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> rearrangeLastN(ListNode<Integer> head, int k) {
    if (k == 0) {
        return head;
    }
    int count = 0;
    ListNode<Integer> iter = head;
    ListNode<Integer> begin = head;
    ListNode<Integer> prev = null;
    ListNode<Integer> prevIter = null;
    while (iter != null) {
        if (count < k) {
            count++;
        } else {
            prev = begin;
            begin = begin.next;
        }
        prevIter = iter;
        iter = iter.next;
    }
    if (prev == null) {
        return begin;
    }
    prev.next = null;
    prevIter.next = head;
    return begin;
}
