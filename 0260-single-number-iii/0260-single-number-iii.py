class Solution:
    def singleNumber(self, nums: list[int]) -> list[int]:
        xor = 0
        for n in nums:
            xor ^= n
            
        bit = xor & -xor

        a = b = 0
        for n in nums:
            if n & bit:
                a ^= n
            else: 
                    b ^= n
        return [a,b]
                    
