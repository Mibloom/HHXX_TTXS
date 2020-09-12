package leetcode.editor.cn;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针
class 盛最多水的容器{
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            // 暴力解法
//            int max = 0;
//            for (int i = 0; i < height.length; i++){
//                for(int j = i + 1; j < height.length; j++){
//                    int area = (j - i) * Math.min(height[i],height[j]);
//                    max = Math.max(max,area);
//                }
//            }
//            return max;

               // 双指针法，面积大小取决于两点之间的距离和最短边，两指针往中间走，遇到短边就继续往前走，去寻找更长的边，直到相遇
            int max= 0;
            int i = 0;
            int j = height.length - 1;
            while(i < j){
                int h = height[i] < height[j] ? height[i++] : height[j--];
                int area = (j - i + 1) * h;
                max = Math.max(max,area);
            }
            return max;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



