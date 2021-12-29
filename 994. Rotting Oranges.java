class Solution {
    public int orangesRotting(int[][] grid) {
        //bfs
        /*每一轮里一个rotten cell只会用一次，因为一分钟后会将其周围的fresh cells都rotten了*/
        
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int time = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                for (int[] dir : dirs) {
                    int nx = dir[0] + rotten[0];
                    int ny = dir[1] + rotten[1];
                    if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length || grid[nx][ny] != 1) continue;
                    grid[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                    fresh--;
                }
            }
             time++;
        }
        return fresh == 0 ? time : -1;
    }
}
