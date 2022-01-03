class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> devices = new ArrayList<>();
        for (String row : bank) {
            int cnt = 0;
            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) == '1') {
                    cnt++;
                }
            }
            if (cnt > 0) {
                devices.add(cnt);
            }
        }
        if (devices.size() > 0) {
            int prev = devices.get(0);
            int res = 0;
            for (int i = 1; i < devices.size(); i++) {
                res += prev * devices.get(i);
                prev = devices.get(i);
            }
            return res;
        }
        return 0;
    }
}
