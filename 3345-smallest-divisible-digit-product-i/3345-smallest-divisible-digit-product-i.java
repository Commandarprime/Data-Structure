class Solution {
    public int smallestNumber(int n, int t) {
        long num = n;
        
        while (true) {
            if (digitProduct(num) % t == 0) {
                return (int) num;
            }
            num++;
        }
    }
    
    private long digitProduct(long num) {
        long product = 1;
        while (num > 0) {
            product *= (num % 10);
            num /= 10;
        }
        return product;
    }
}