class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
         int sum = 0, direct = 0;
        
        for (int dist : distance) {
            sum += dist;
        }
        int len = distance.length;
        
        for (int i = Math.min(start, destination); i < Math.max(start, destination); i++) {
            direct += distance[i];
        }
        return Math.min(sum - direct, direct);
    }
}
