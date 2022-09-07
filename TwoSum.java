import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    public int[] twoSumWithHashMap(int[] nums, int target) {

        Map<Integer, Integer> numsMap = new HashMap<>();

        for(int p=0; p < nums.length; p++) {
            if(numsMap.containsKey(nums[p]))
                return new int[] {numsMap.get(nums[p]), p};
            else {
                int numToFind = target - nums[p];
                numsMap.put(numToFind, p);
            }
        }

        return null;
    }


    public int[] twoSum(int[] nums, int target) {

        int length = nums.length;

        if( length >= 2 && length <= Math.pow(10, 4) && target >= Math.pow(-10, 9) &&
                target <= Math.pow(10, 9) ) {
            List<Integer> diffList = new ArrayList<>();

            for(int i=0; i < length; i++) {
                if (nums[i] >= Math.pow(-10, 9) && nums[i] <= Math.pow(10, 9) ) {
                    int diff = target - nums[i];
                    if(diffList.contains(nums[i]))
                        return new int[]{diffList.indexOf(nums[i]), i};
                    diffList.add(diff);
                }
                else {
                    return null;
                }
            }
        }
        else {
            return null;
        }

        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
//        int[] sumIndex = twoSum.twoSum(new int[]{3,3}, 6);
        //int[] sumIndex = twoSum.twoSum(new int[]{2, 7, 5, 11}, 9);
//        int[] sumIndex = twoSum.twoSumWithHashMap(new int[]{3,3}, 6);
//        int[] sumIndex = twoSum.twoSumWithHashMap(new int[]{2, 7, 5, 11}, 9);
        int[] sumIndex = twoSum.twoSumWithHashMap(new int[]{1, 3, 7, 9, 2}, 11);
        System.out.println( sumIndex[0] +"," + sumIndex[1] );
    }

}
