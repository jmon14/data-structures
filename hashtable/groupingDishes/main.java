String[][] solution(String[][] dishes) {
    Map<String, ArrayList<String>> ingMap = new HashMap<>();
    for (int i = 0; i < dishes.length; i++) {
        String dish = dishes[i][0];
        for(int j = 1; j < dishes[i].length; j++) {
            ArrayList<String> dishList = ingMap.get(dishes[i][j]);
            if (dishList == null) {
                dishList = new ArrayList<String>();
                dishList.add(dish);
                ingMap.put(dishes[i][j], dishList);
            } else {
                dishList.add(dish);
            }
        }
    }
    ArrayList<String[]> list = new ArrayList<>();
    String[] ingArr = ingMap.keySet().toArray(new String[0]);
    Arrays.sort(ingArr);
    
    for (int i = 0; i < ingArr.length; i++) {
        ArrayList<String> dishList = ingMap.get(ingArr[i]);
        if (dishList.size() > 1) {
            Collections.sort(dishList);
            dishList.add(0, ingArr[i]);
            String[] dishArr = dishList.toArray(new String[0]);
            list.add(dishArr);
        }
    }
    
    String[][] finalList = list.toArray(new String[0][0]);
    
    return finalList;
}