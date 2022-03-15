// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
boolean isListPalindrome(ListNode<Integer> l) {
    ListNode<Integer> slowPtr;
    ListNode<Integer> fastPtr;
    ListNode<Integer> prevSlowPtr;
    boolean palindrome = true;
    if (l != null && l.next != null) {
        slowPtr = l;
        fastPtr = l;
        prevSlowPtr = l;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            prevSlowPtr = slowPtr;
            slowPtr = slowPtr.next;
        }
        if (fastPtr != null) {
            slowPtr = slowPtr.next;
        }
        prevSlowPtr.next = null;
        ListNode<Integer> prev = null;
        ListNode<Integer> next = slowPtr;
        while (slowPtr != null) {
            next = slowPtr.next;
            slowPtr.next = prev;
            prev = slowPtr;
            slowPtr = next;
        }
        while (l != null && prev != null) {
            if (!l.value.equals(prev.value)) {
                palindrome = false;
                break;
            }
            l = l.next;
            prev = prev.next;
        }
    }
    
    return palindrome;
}
