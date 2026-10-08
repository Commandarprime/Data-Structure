class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        if dividend == -2**31 and divisor == -1:
            return 2**31 - 1

        negative = (dividend < 0) != (divisor < 0)
        a, b = abs(dividend), abs(divisor)
        result = 0

        for i in range(31, -1, -1):
            if (a >> i) >= b:
                a -= b << i
                result += 1 << i

        return -result if negative else result