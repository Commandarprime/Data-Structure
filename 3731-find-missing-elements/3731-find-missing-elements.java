class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];

        for(int i=1; i<nums.length; i++){
           if(nums[i]>max){
            max = nums[i];
           }
           else if(nums[i]<min){
          min = nums[i];
           }
        }
        Set<Integer> present = new HashSet<>();
        for(int num:nums){
            present.add(num);
        }

        List<Integer> result = new ArrayList<>();
       for(int x = min+1; x<max; x++){
        if(!present.contains(x)){
            result.add(x);
        }
       }
       return result;
    }
}