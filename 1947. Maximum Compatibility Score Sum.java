

/**
reference

https://blog.csdn.net/zml66666/article/details/119285160

**/

class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length, n = students[0].length;

        //预处理得到每对师生间的兼容性评分
        int[][] score = new int[m][m];//score[i][j]表示第i个学生和第j个导师间的兼容性评分
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                score[i][j] = 0;//初始化
                for (int k = 0; k < n; k++)
                    if (students[i][k] == mentors[j][k])//答案一致，评分+1
                        score[i][j]++;
            }
        }

        //状态压缩 + 动态规划
        int range = 1 << m;//压缩后的范围[0,2^m-1]
        int[] dp = new int[range];//dp[i]中i的第x位为1，表示第x位导师已被分配，为0表示该导师尚未分配，dp[i]表示该分配状态下当前的最大兼容性评分和
        Arrays.fill(dp, 0);//初始化
        for (int i = 0; i < range; i++) {//遍历所有可能的分配状态
            int count = Integer.bitCount(i);//i中有count位为1，说明正在分配导师的是第count-1位学生
            for (int j = 0; j < m; j++) {//尝试匹配所有导师
                if (((i >> j) & 1) == 1)//状态i中第j位导师需被分配
                    dp[i] = Math.max(dp[i], dp[i ^ (1 << j)] + score[count - 1][j]);//尝试用第count-1位学生和第j位导师的分配方案更新dp
            }
        }
        return dp[range - 1];//全部导师被分配时的最大兼容性评分和，就是待求解的答案
    }
}
