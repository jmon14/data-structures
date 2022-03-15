boolean isCryptSolution(String[] crypt, char[][] solution) {
    HashMap<Character, Integer> charToNum = new HashMap<Character, Integer>();
    for (int i = 0; i < solution.length; i++) {
        charToNum.put(solution[i][0], Character.getNumericValue(solution[i][1]));
    }
    int len = crypt[0].length();
    long first = 0;
    for (int i = 0; i < len; i++) {
        int charNum = charToNum.get(crypt[0].charAt(i));
        if (i == 0 && charNum == 0 && len > 1) {
            return false;
        }
        first += charNum * Math.pow(10, len - i - 1);
    }
    len = crypt[1].length();
    long second = 0;
    for (int i = 0; i < len; i++) {
        int charNum = charToNum.get(crypt[1].charAt(i));
        if (i == 0 && charNum == 0 && len > 1) {
            return false;
        }
        second += charNum * Math.pow(10, len - i - 1);
    }
    len = crypt[2].length();
    long result = 0;
    for (int i = 0; i < len; i++) {
        int charNum = charToNum.get(crypt[2].charAt(i));
        if (i == 0 && charNum == 0 && len > 1) {
            return false;
        }
        result += charNum * Math.pow(10, len - i - 1);
    }
    if (first + second == result) {
        return true;
    }
    return false;
}
