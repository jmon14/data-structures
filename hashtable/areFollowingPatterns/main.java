boolean solution(String[] strings, String[] patterns) {
    boolean pattern = true;
    Map<String, String> strMap = new HashMap<String, String>();
    Map<String, String> patMap = new HashMap<String, String>();
    for (int i = 0; i < strings.length; i++) {
        String str = strMap.get(patterns[i]);
        if (str == null) {
            strMap.put(patterns[i], strings[i]);
        } else {
            if (!strings[i].equals(str)) {
                pattern = false;
                break;
            }
        }
        String pat = patMap.get(strings[i]);
        if (pat == null) {
            patMap.put(strings[i], patterns[i]);
        } else {
            if (!patterns[i].equals(pat)) {
                pattern = false;
                break;
            }
        }
    }
    return pattern;
}