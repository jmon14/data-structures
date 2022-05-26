boolean sudoku2(char[][] grid) {
    boolean valid = true;
    for (int i = 0; i < 9; i++) {
        if (!valid) {
            break;
        }
        HashSet<Integer> rows = new HashSet<Integer>();
        HashSet<Integer> cols = new HashSet<Integer>();
        HashSet<Integer> sqrs = new HashSet<Integer>();
        for (int j = 0; j < 9; j++) {
            // rows comparison
            int a = Character.getNumericValue(grid[i][j]);
            if (a > 0) {
                if (rows.contains(a)) {
                    valid = false;
                    break;
                }
                boolean b = rows.add(a);
            }
            // cols comparison
            a = Character.getNumericValue(grid[j][i]);
            if (a > 0) {
                if (cols.contains(a)) {
                    valid = false;
                    break;
                }
                cols.add(a);
            }
            // sqrs comparison
            int sqrRow = i / 3;
            int sqrCol = i % 3;
            int inSqrRow = j / 3;
            int inSqrCol = j % 3;
            a = Character.getNumericValue(grid[(3 * sqrRow) + inSqrRow][(3 * sqrCol) + inSqrCol]);
            if (a < 0) {
                continue;
            }
            if (sqrs.contains(a)) {
                valid = false;
                break;
            }
            sqrs.add(a);
        }
    }
    return valid;
}
