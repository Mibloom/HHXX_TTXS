package leetcode.editor.cn;

import java.util.*;

class 八皇后 {
    static

//设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整
//个棋盘的那两条对角线。 
//
// 注意：本题相对原题做了扩展 
//
// 示例: 
//
//  输入：4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics 回溯算法 
// 👍 41 👎 0


            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n;
        int[][] chess;
        ArrayList<List<String>> list = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            this.chess = new int[n][n];
            solve(0);
            return list;
        }

        void solve(int row) {
            if (row == n) {
                list.add(cast(chess));
                return;
            }
            for (int col = 0; col < n; col++) {
                if (verify(row, col)) {
                    chess[row][col] = 'Q';
                    solve(row + 1);
                    chess[row][col] = '.';
                }
            }
        }

        boolean verify(int row, int col) {
            for (int i = 0; i < row; i++) {
                if (chess[i][col] == 'Q') {
                    return false;
                }
            }
            for (int x = row - 1, y = col - 1; x >= 0 && y >= 0; x--, y--) {
                if (chess[x][y] == 'Q') {
                    return false;
                }
            }
            for (int x = row - 1, y = col + 1; x >= 0 && y < n; x--, y++) {
                if (chess[x][y] == 'Q') {
                    return false;
                }
            }
            return true;
        }

        List<String> cast(int[][] chess) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (chess[i][j] == 'Q') {
                        builder.append("Q");
                    } else {
                        builder.append(".");
                    }
                }
                list.add(builder.toString());
            }
            return list;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveNQueens(4);
        System.out.println(solution.list.size());
    }

}

