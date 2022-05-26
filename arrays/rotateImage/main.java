int[][] rotateImage(int[][] a) {
    int n = a.length;
    for (int i = 0; i < n / 2; i++) {
        for (int j = i; j < n - i - 1; j++) {
            int last = a[i][j];
            int next = a[j][n - i - 1];
            a[j][n - i - 1] = last;
            last = next;
            next = a[n - i - 1][n - j - 1];
            a[n - i - 1][n - j - 1] = last;
            last = next;
            next = a[n - j - 1][i];
            a[n - j - 1][i] = last;
            a[i][j] = next;
        }
    }
    return a;
}
