class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        
        int ans = high; // worst case fallback
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canFinish(piles, h, mid)) {
                ans = mid;       // mid valid hai, but try kam speed
                high = mid - 1;
            } else {
                low = mid + 1;   // mid slow hai, speed badhao
            }
        }
        
        return ans;
    }
    
    private boolean canFinish(int[] piles, int h, int k) {
        long totalHours = 0;
        for (int pile : piles) {
            totalHours += Math.ceil((double) pile / k);
            // ya: totalHours += (pile + k - 1) / k;  (integer trick, faster)
        }
        return totalHours <= h;
    }
}