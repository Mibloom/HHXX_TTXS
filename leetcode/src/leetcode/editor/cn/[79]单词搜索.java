package leetcode.editor.cn;

import java.util.*;

class 单词搜索 {

//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 628 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m;
        int n;
        char[][] board;
        boolean[][] mark;
        String word;
        int[][] path = {{0,1},{1,0},{0,-1},{-1,0}};
        public boolean exist(char[][] board, String word) {
           this.m = board.length;
           this.n = board[0].length;
           this.board = board;
           this.word = word;
           mark = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (helper(i,j,0)){
                        return true;
                    }
                }
            }
            return false;
        }
        boolean helper(int x, int y, int start){
            if (start == word.length() - 1){
                return board[x][y] == word.charAt(start);
            }
            mark[x][y] = true;
            if (board[x][y] == word.charAt(start)){
                for (int i = 0; i < 4; i++) {
                    int newX = x + path[i][0];
                    int newY = y + path[i][1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && !mark[newX][newY]){
                        if (helper(newX,newY,start + 1)){
                            return true;
                        }
                    }
                }

            }
            mark[x][y] = false;
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}