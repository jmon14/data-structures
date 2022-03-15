ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
    boolean first = true;
    ListNode<Integer> iter = l;
    ListNode<Integer> last = l;
    while (iter != null) {
        if (iter.value == k) {
            if (first) {
                l = l.next;
                last = l;
            } else {
                last.next = iter.next;
            }
        } else {
            if (first) {
                first = false;
            } else {
                last = last.next;
            }
        }
        iter = iter.next;
    }
    return l;
}
