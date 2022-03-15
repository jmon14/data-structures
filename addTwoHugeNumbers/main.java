// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
    ListNode<Integer> res = null;
    ListNode<Integer> iter = null;
    if (a != null) {
        if (a.next != null) {
            a = reverse(a);
        }
    } else {
        return b;
    }
    if (b != null) {
        if (b.next != null) {
            b = reverse(b);
        }
    } else {
        return a;
    }
    boolean acumm = false;
    while (a != null || b != null) {
        int newVal = 0;
        if (acumm) {
            newVal = 1;
            acumm = false;
        }
        if (a != null) {
            newVal += a.value;
            a = a.next;
        }
        if (b != null) {
            newVal += b.value;
            b = b.next;
        }
        if (newVal >= 10000) {
            newVal = newVal % 10000;
            acumm = true;
        }
        ListNode<Integer> newNode = new ListNode(newVal);
        if (res == null) {
            res = newNode;
            iter = res;
        } else {
            iter.next = newNode;
            iter = newNode;
        }
    }
    if (acumm) {
        ListNode<Integer> last = new ListNode(1);
        iter.next = last;
    }
    res = reverse(res);
    return res;
}

ListNode<Integer> reverse(ListNode<Integer> curr) {
    ListNode<Integer> prev = null;
    ListNode<Integer> next = curr;
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
