class Solution {
  
  //reference: guifeng大神
  //https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1691.Maximum-Height-by-Stacking-Cuboids
  
  
  
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        int[][] shapes = new int[n * 6][4];
        for (int i = 0; i < n; i++) {
            int[] cub = cuboids[i];
            int l = cub[0];
            int w = cub[1];
            int h = cub[2];
            shapes[6 * i + 0] = new int[]{l, w, h, i};
            shapes[6 * i + 1] = new int[]{l, h, w, i};
            shapes[6 * i + 2] = new int[]{w, l, h, i};
            shapes[6 * i + 3] = new int[]{w, h, l, i};
            shapes[6 * i + 4] = new int[]{h, w, l, i};
            shapes[6 * i + 5] = new int[]{h, l, w, i};
        }
        Arrays.sort(shapes, (a, b) -> {
            int one = Integer.compare(a[0], b[0]);
            if (one != 0) {
                return one;
            }
            int two = Integer.compare(a[1], b[1]);
            if (two != 0) {
                return two;
            }
            int three = Integer.compare(a[2], b[2]);
            if (three != 0) {
                return three;
            }
            return Integer.compare(a[3], b[3]);
        });
        int[] dp = new int[6 * n];
        for (int i = 0; i < 6 * n; i++) {
            dp[i] = shapes[i][2];
            for (int j = 0; j < i; j++) {
                if (shapes[j][0] <= shapes[i][0] && shapes[j][1] <= shapes[i][1] && shapes[j][2] <= shapes[i][2] && shapes[j][3] != shapes[i][3]) {
                    dp[i] = Math.max(dp[i], dp[j] + shapes[i][2]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 6 * n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
