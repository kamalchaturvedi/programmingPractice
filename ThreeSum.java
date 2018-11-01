import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ThreeSum {
	public static void main(String[] args) {
		int[] numbers = {-7,-5,5,-6,-2,1,7,3,-4,-2,-2,-4,-8,-1,8,8,-2,-7,3,2,-7,8,-3,-10,5,2,8,7,7};
		threeSum(numbers);
	}

	public static List<List<Integer>> threeSum(int[] nums) {
        	Map<String,List<Integer>> mapping = new HashMap<String,List<Integer>>();
        	List<List<Integer>> output = new ArrayList();
        	Arrays.sort(nums);
        	if(nums.length >= 3){
            		getOutputElements(nums, mapping);
        	}
        	for(Map.Entry<String,List<Integer>> entry:mapping.entrySet()){
            		output.add(entry.getValue());
        	}
        	return output;
    }
    static void getOutputElements(int[] nums, Map<String,List<Integer>> mapping){
        int first,last,sum;
        for(int i = 0; i< (nums.length-2);i++){
            first = i+1;
            last = nums.length - 1;
            while(first < last){
                sum = nums[i] + nums[first] + nums[last];
                if(sum == 0){
                    mapping.put(String.valueOf(nums[i])+String.valueOf(nums[first])+String.valueOf(nums[last]), Arrays.asList(nums[i] ,nums[first],nums[last]));
                    ++first;
                    --last;
                }
                if(sum > 0)
                    --last;
                else if(sum < 0)
                    ++first;
            }
        }
    }
}
