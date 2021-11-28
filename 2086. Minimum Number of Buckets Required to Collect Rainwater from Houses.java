class Solution {
    public int minimumBuckets(String street) {
        int bucket = 0;
        if (street.indexOf("H") == -1) {
            return 0;
        }
        if (street.indexOf(".") == -1 || street.indexOf("HHH") != -1 || street.startsWith("HH") || street.endsWith("HH")) {
            return -1;
        }
        int n = street.length();
        boolean[] flag = new boolean[n];
        
        //int count = 0;
        for (int i = 0; i < n; i++) {
            char c = street.charAt(i);
            if (c == 'H') {
               if (i > 0 && street.charAt(i - 1) == '.' && flag[i - 1]) {
                   flag[i] = true;
               } 
               
              
            } else {
               if ((i > 0 && street.charAt(i - 1) == 'H' && !flag[i - 1])
                   || 
                   (i + 2 == n && street.charAt(i + 1) == 'H') 
                   || 
                   (i + 2 < n && street.charAt(i + 1) == 'H' && street.charAt(i + 2) == 'H')) {
                   bucket++;
                   flag[i] = true;
                }
                
            }
        }
        return bucket;
    }
}
