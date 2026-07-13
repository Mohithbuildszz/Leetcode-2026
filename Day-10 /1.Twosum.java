class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer,Integer> answer = new HashMap<>();
      for(int i=0;i<nums.length;i++){
        int store = target - nums[i];
        if(answer.containsKey(store)){
            return new int[]{answer.get(store), i};
        }
        answer.put(nums[i], i);
      } 
      return new int[]{};
    }
}
