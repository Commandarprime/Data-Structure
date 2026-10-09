class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        res = []
        path = []

        def backtrack(i):
            res.append(path[:])

            for j in range(i, len(nums)):
                path.append(nums[j])
                backtrack(j + 1)
                path.pop()

        backtrack(0)
        return res