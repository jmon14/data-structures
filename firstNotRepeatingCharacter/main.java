char firstNotRepeatingCharacter(String s) {
    ArrayList<Character> unique = new ArrayList<Character>();
    HashSet<Character> repeated = new HashSet<Character>();
    for (int i = 0; i < s.length(); i++){
        char c = s.charAt(i);        
        if (!repeated.contains(c)) {
            int index = unique.indexOf(c);
            if (index != -1) {
                repeated.add(c);
                unique.remove(index);
            } else {
                unique.add(c);
            }
        }
    }
    if (unique.size() > 0) {
        char c = unique.get(0);
        return c;
    }
    return '_';
}
