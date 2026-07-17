class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int itr = 0;itr<n-3;itr++){
            if(itr > 0 && nums[itr] == nums[itr - 1]){
                continue;
            } 
        for(int jtr=itr + 1;jtr<n-2;jtr++){
            if(jtr > itr+1 && nums[jtr] == nums[jtr - 1]){
                continue;
            } 
        int left = jtr + 1;
        int right = n - 1;
        while(left < right){
            long sum = (long) nums[itr] + nums[jtr] + nums[left] + nums[right];
            if(sum == target){
                ans.add(Arrays.asList(nums[itr],nums[jtr],nums[left],nums[right]));
                left ++;
                right --;
        
            while(left<right && nums[left] == nums[left -1]){
                left ++;
            } 
            while(left <right && nums[right] == nums[right + 1]){
                right --;
             }
            }
             else if (sum < target) {
                left ++;
            } else {
                right --;
                       }
                   }
                }
              }
        return ans;
    }
}
