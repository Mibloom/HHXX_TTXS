package leetcode.editor.cn;
import java.util.*;

class 排序数组{

//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 166 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2){
            return nums;
        }
        sort(nums,0,nums.length - 1);
        return nums;

    }

    void sort(int[] nums, int start, int end){
        if (start >= end){
            return;
        }
        int index = helper(nums,start,end);
        sort(nums,start,index - 1);
        sort(nums,index + 1,end);
    }
    int helper(int[] nums, int start, int end){
        int left = start;
        int right = end;
        int key = nums[start];

        while (left != right){
            while (left < right && nums[right] > key){
                right--;
            }
            while (left < right && nums[left] <= key){
                left++;
            }
            if (left < right){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
        int temp = nums[left];
        nums[left] = key;
        nums[start] = temp;
        return left;
    }


}
//leetcode submit region end(Prohibit modification and deletion)





}