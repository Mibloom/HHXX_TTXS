package happy.sort;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/9/20 9:48
 **/
public class 二分查找算法 {
    public static void main(String[] args) {
        search(new int[]{-1,0,3,5,9,12},2);
    }
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
