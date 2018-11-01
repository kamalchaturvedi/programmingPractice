class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSumToTarget = Integer.MAX_VALUE;
        if(nums.length >= 3){
            int start = 0,end = nums.length -1;
            closestSumToTarget = getClosestSumToTarget(nums, target);
        }
        return closestSumToTarget;
    }
    int getClosestSumToTarget(int[] nums, int target){
        int first,last,sum;
        int currentClosestMod = Integer.MAX_VALUE, closestSum = -1;
        for(int i = 0; i< (nums.length-2);i++){
            first = i+1;
            last = nums.length - 1;
            while(first < last){
                sum = nums[i] + nums[first] + nums[last];
                if((Math.abs(sum - target) < currentClosestMod) || (sum - target == 0)){
                    currentClosestMod = Math.abs(sum - target);
                    closestSum = sum;
                }
                if(sum - target > 0)
                    --last;
                else if(sum - target < 0)
                    ++first;
                else if(sum == target)
                    return closestSum;
            }
        }
        return closestSum;
    }
}
