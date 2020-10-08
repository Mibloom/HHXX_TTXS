package happy.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author LIPENGKE
 *
 * 时间复杂度：O(N \log N)O(NlogN)，这里 NN 是数组的长度；
 * 空间复杂度：O(\log N)O(logN)，这里占用的空间主要来自递归函数的栈空间。
 * @date 2020/9/20 9:48
 **/
public class 快速排序 {
    public static void main(String[] args) {
        int[] ints = {7, 4, 8, 2, 1, 6, 3, 0, 8, 2, 9, 4};
        quickSort(ints,0,ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    static void quickSort(int[] nums, int start, int end){
        if (start >= end){
            return;
        }
        int index = helper2(nums,start,end);
        quickSort(nums,start,index - 1);
        quickSort(nums, index + 1, end);
    }
    // 双边循环
   static int helper(int[] nums, int start, int end){
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
        int temp = nums[right];
        nums[right] = key;
        nums[start] = temp;
        return left;
    }
    // 单边循环。标记一个mark, mark起始位置是0，然后遍历数组，如果比基准值大，则继续遍历，如果比
    // 基准值小则 mark++, 然后和mark位置交互顺序。
    // 快排一个原则就是每一轮遍历，基准值不允许变化
   static int helper2(int[] nums, int start, int end){
        int mark = start;
        int key  = nums[start];
        for (int i = start + 1; i < end + 1; i++) {
            if (nums[i] < key){
                mark++;
                int temp = nums[i];
                nums[i] = nums[mark];
                nums[mark] = temp;
            }
        }
        nums[start] = nums[mark];
        nums[mark] = key;
        return mark;
    }

}
