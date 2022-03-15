int firstDuplicate(int[] a) {
    int[] b = new int[a.length];
    for (int i = 0; i < a.length; i++) {
        if (b[a[i] - 1] == 0) {
            b[a[i] - 1] = 1;
        } else {
            return a[i];
        }
    }
    return -1;
}
