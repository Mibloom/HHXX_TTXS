package leetcode.editor.cn;
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //System.arraycopy(nums2,0,nums1,m,n);
        //        //Arrays.sort(nums1);

        // 指针从前往后遍历，需要额外的空间保存要被改变的num1
        //int[] copy = new int[m];
        //System.arraycopy(nums1,0,copy,0,m);
        //
        //int p1 = 0;
        //int p2 = 0;
        //int p = 0;
        //
        //while (p1 < m && p2 < n){
        //    if (copy[p1] <= nums2[p2]){
        //        nums1[p] = copy[p1];
        //        p++;
        //        p1++;
        //    }else {
        //        nums1[p] = nums2[p2];
        //        p++;
        //        p2++;
        //    }
        //}
        //if (p1 < m){
        //    System.arraycopy(copy,p1,nums1,p1+p2,m-p1+n-p2);
        //}
        //if (p2 < n){
        //    System.arraycopy(nums2,p2,nums1,p1+p2,m-p1+n-p2);
        //}

        // 从后往前遍历，则不要额外的空间

        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
          nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        if (p1 < 0){
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
