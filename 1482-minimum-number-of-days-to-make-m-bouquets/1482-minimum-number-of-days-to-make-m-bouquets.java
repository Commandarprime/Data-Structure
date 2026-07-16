class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        
       
        if ((long) m * k > n) return -1;
        
        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            lo = Math.min(lo, day);
            hi = Math.max(hi, day);
        }
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;  
            
            if (canMake(bloomDay, mid, m, k)) {
                hi = mid;  
            } else {
                lo = mid + 1;  
            }
        }
        
        return lo;
    }
    
    private boolean canMake(int[] bloomDay, int day, int m, int k) {
        int bouquets = 0, streak = 0;
        
        for (int b : bloomDay) {
            if (b <= day) {
                streak++;
                if (streak == k) {
                    bouquets++;
                    streak = 0;   
                }
            } else {
                streak = 0;
            }
        }
        
        return bouquets >= m;
    }
}