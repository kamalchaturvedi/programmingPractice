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
		Map<String, List<Integer>> mapping = new HashMap<String, List<Integer>>();
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		if (nums.length >= 3) {
			int start = 0, end = nums.length - 1;
			getOutputElements(nums, start, end, mapping);
		}
		for (Map.Entry<String, List<Integer>> entry : mapping.entrySet()) {
			output.add(entry.getValue());
		}
		return output;
	}

	static void getOutputElements(int[] nums, int start, int end, Map<String, List<Integer>> mapping) {
		if(end - start < 2){
            return;
        }
        else{
            int midElementIndex = findThirdEligibleElement(nums, 0 - (nums[start]+nums[end]),start+ 1, end - 1);
            if(midElementIndex != -1){
                mapping.put(String.valueOf(nums[start]) + String.valueOf(nums[midElementIndex]) + String.valueOf(nums[end]), Arrays.asList(nums[start],nums[midElementIndex],nums[end]));
            }
            getOutputElements(nums, start+1, end, mapping);
            getOutputElements(nums, start, end-1, mapping);
        }
	}

	static int findThirdEligibleElement(int[] nums, int value, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (nums[mid] == value) {
			return mid;
		} else if (nums[mid] > value) {
			return findThirdEligibleElement(nums, value, start, mid - 1);
		} else
			return findThirdEligibleElement(nums, value, mid + 1, end);
	}
}
