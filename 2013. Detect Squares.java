class DetectSquares {

    /**
    
    这题和939很像，找一个长方形或者正方形，关键如下图所示，p1.x == p4.x, p1.y == p2.y, p2.x == p3.x, p3.y == p4.y
    p4  p3
    p1  p2
    
    **/
    Map<Integer, Map<Integer, Integer>> xy;
    public DetectSquares() {
        xy = new HashMap<>();
    }
    
    public void add(int[] point) {
        Map<Integer, Integer> ys = xy.getOrDefault(point[0], new HashMap<>());
        int cnt = ys.getOrDefault(point[1], 0);
        ys.put(point[1], cnt + 1);
        xy.put(point[0], ys);
    }
    
    public int count(int[] point) {
        int res = 0;
        int x = point[0], y = point[1];
        if (!xy.containsKey(x)) return 0;
        for (int r : xy.keySet()) {
            if (r != x) {
                
                Map<Integer, Integer> rys = xy.get(r);
                if (!rys.containsKey(y) ) {
                    continue;
                }
                for (int yc : rys.keySet()) {
                    if (yc != y && xy.get(x).containsKey(yc) && Math.abs(x - r) == Math.abs(y - yc)) {
                        res += (xy.get(x).get(yc) * xy.get(r).get(y) * xy.get(r).get(yc));
                    }
                }
            }
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
