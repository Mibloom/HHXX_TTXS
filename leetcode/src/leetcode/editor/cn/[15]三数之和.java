package leetcode.editor.cn;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 三数之和{

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // 暴力法，超时未AC
//            Arrays.sort(nums);
//            ArrayList<List<Integer>> result = new ArrayList<>();
//            for(int i = 0; i < nums.length; i++){
//                for (int j = i + 1; j < nums.length; j++){
//                    for (int k = j + 1; k < nums.length; k++){
//                        if (nums[i] + nums[j] + nums[k] == 0){
//                            ArrayList<Integer> list = new ArrayList<>();
//                            list.add(nums[i]);
//                            list.add(nums[j]);
//                            list.add(nums[k]);
//                            if (!result.contains(list)){
//                                result.add(list);
//                            }
//                        }
//                    }
//                }
//            }
//            return result;

            // 固定一个数，再使用双指针法
            Arrays.sort(nums);
            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                if (nums[i] > 0){
                    return list;
                }
                if (i > 0 && nums[i] == nums[i - 1]){
                    continue;
                }
                int l = i + 1;
                int r = nums.length - 1;
                while(l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0){
                        list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        while ((l < r) && nums[l] == nums[++l]){}
                        while ((l < r) && nums[r] == nums[--r]){}
                    }else if (sum < 0){
                        while ((l < r) && nums[l] == nums[++l]){}
                    }else {
                        while ((l < r) && nums[r] == nums[--r]){}
                    }
                }
            }
            return list;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        int[] nums = new int[]{-1,-1,3,4,5};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i);
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            System.out.println("end:"+i);

        }

    }

}


