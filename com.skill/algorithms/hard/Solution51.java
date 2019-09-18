package algorithms.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>N皇后</p>
 *
 * @author chendaoheng
 * @date 2019/9/18 15:22
 */
public class Solution51 {
    /**
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * <p>
     * 图八缺失，可以直接查看原题：https://leetcode-cn.com/problems/n-queens
     * <p>
     * 上图为 8 皇后问题的一种解法。
     * <p>
     * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
     * <p>
     * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * <p>
     * 示例:
     * <p>
     * 输入: 4
     * 输出: [
     * [".Q..",  // 解法 1
     * "...Q",
     * "Q...",
     * "..Q."],
     * <p>
     * ["..Q.",  // 解法 2
     * "Q...",
     * "...Q",
     * ".Q.."]
     * ]
     * 解释: 4 皇后问题存在两个不同的解法。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-queens
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 用于存储符合情况的N皇后
     */
    private int[] queens;

    /**
     * 结果集
     */
    private List<List<String>> result = new ArrayList<List<String>>();

    public List<List<String>> solveNQueens(int n) {
        queens = new int[n];
        //从第一列开始尝试
        calQueens(0);
        return result;
    }

    /**
     * 尝试
     *
     * @param row 尝试的行
     */
    private void calQueens(int row) {
        //如果N列都摆好了就可以终止尝试了
        if (row == queens.length) {
            result.add(getQueens(queens));
            return;
        }
        for (int col = 0; col < queens.length; ++col) {
            if (isOk(row, col)) {
                queens[row] = col;
                //上一列摆好了尝试下一列
                calQueens(row + 1);
            }
        }

    }

    /**
     * 判断是否可以摆放皇后
     *
     * @param row 行
     * @param col 列
     * @return 判断结果
     */
    private boolean isOk(int row, int col) {
        int leftup = col - 1, rightup = col + 1;
        for (int i = row - 1; i >= 0; --i) {
            //判断该列是否已有皇后
            if (queens[i] == col) return false;
            if (leftup >= 0) {
                //左上角是否已有皇后
                if (queens[i] == leftup) return false;
            }
            if (rightup < queens.length) {
                //右上角是否已有皇后
                if (queens[i] == rightup) return false;
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    /**
     * 按题目要求获取字符串集合。不含N皇后逻辑
     *
     * @param queens 格式化前的皇后记录
     * @return 格式化后的皇后列表
     */
    private List<String> getQueens(int[] queens) {//
        StringBuilder sb;
        List<String> list = new ArrayList<>();
        for (int row = 0; row < queens.length; ++row) {
            sb = new StringBuilder();
            for (int col = 0; col < queens.length; ++col) {
                if (queens[row] == col) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        return list;
    }
}
