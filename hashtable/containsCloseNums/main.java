boolean solution(int[] arr, int k) {
    boolean flag = false;
    Map<Integer, Integer> intMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < arr.length; i++) {
        Integer found = intMap.get(arr[i]);
        if (found == null) {
            intMap.put(arr[i], i);
        } else {
            int dif = i - found;
            if (dif <= k) {
                flag = true;
                break;
            } else {
                intMap.put(arr[i], i);
            }
        }
    }
    return flag;
}