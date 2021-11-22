class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]);
            }
        });
        for (int [] p : points) {
            if (heap.size() < K) {
                heap.offer(p);
            } else {
                int[] top = heap.peek();
                if (top[0] * top[0] + top[1] * top[1] > p[0] * p[0] + p[1] * p[1]) {
                    heap.poll();
                    heap.offer(p);
                }
                
            }
        }
        int[][] res = new int[K][2];
        int i = 0;
        while (heap.size() > 0) {
            res[i++] = heap.poll();
        }
        return res;
    }
}
