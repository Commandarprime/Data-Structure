class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = Integer.MIN_VALUE, c2 = Integer.MAX_VALUE, cnt1 = 0, cnt2 = 0;

        for (int n : nums) {
            if (n == c1) cnt1++;
            else if (n == c2) cnt2++;
            else if (cnt1 == 0) { c1 = n; cnt1 = 1; }
            else if (cnt2 == 0) { c2 = n; cnt2 = 1; }
            else { cnt1--; cnt2--; }
        }

        cnt1 = cnt2 = 0;
        for (int n : nums) {
            if (n == c1) cnt1++;
            else if (n == c2) cnt2++;
        }

        List<Integer> res = new ArrayList<>();
        int limit = nums.length / 3;
        if (cnt1 > limit) res.add(c1);
        if (cnt2 > limit) res.add(c2);
        return res;
    }
}