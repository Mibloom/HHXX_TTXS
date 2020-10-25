package leetcode.editor.cn;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

import java.util.HashMap;


class 两数之和{

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int len = nums.length;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                if (map.containsKey(target - nums[i])){
                    return new int[]{map.get(target - nums[i]),i};
                }else {
                    map.put(nums[i],i);
                }
            }
            return new int[0];
//            for (int i = 0; i < len - 1; i++) {
//                for (int j = i + 1; j < len; j++) {
//                    if (nums[i] + nums[j] == target){
//                        return new int[]{i,j};
//                    }
//                }
//            }
//            return new int[0];
            // 借助哈希表,哈希表中存储数组中遍历过的元素

//            HashMap<Integer,Integer> map = new HashMap<>();
//            for (int i = 0; i < nums.length; i++){
//                if (map.containsKey(target - nums[i])){
//                    return new int[]{map.get(target - nums[i]),i};
//                }else {
//                     map.put(nums[i],i);
//                }
//            }
//            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


