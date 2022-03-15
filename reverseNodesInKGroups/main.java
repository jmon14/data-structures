// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
    if (k == 1) {
        return l;
    }
    ListNode<Integer> iter = l;
    ListNode<Integer> prev = null;
    for (int i = 0; i < k; i++) {
        if (iter == null) {
            return l;
        }
        prev = iter;
        iter = iter.next;
    }
    prev.next = null;
    l = reverse(l);
    iter = reverseNodesInKGroups(iter, k);
    prev = l;
    while (prev.next != null) {
        prev = prev.next;
    }
    prev.next = iter;
    return l;
}

ListNode<Integer> reverse(ListNode<Integer> l) {
    ListNode<Integer> curr = l;
    ListNode<Integer> prev = null;
    ListNode<Integer> next;
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
