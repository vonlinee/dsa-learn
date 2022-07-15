package question.leetcode.leetbook.easy.dp;

/**
 * 股票买卖问题
 * <p>
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn8fsh/
 * @author vonline
 * @since 2022-07-13 19:47
 */
public class StockTrade {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        // 不能从后向前遍历
        for (int i = 0; i < prices.length; i++) {
            // 当前价格是否是最小价格
            // 最小价格肯定不会是最大利润
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                continue;
            }
            // 当前的利润
            // 价格 - 最小价格 = 最大利润
            int localProfit = prices[i] - minPrice;
            if (localProfit > maxProfit) {
                maxProfit = localProfit;
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) return 0;
        // min = 今天之前买入的最小值，即最低价格
        // max = 最大利润
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        StockTrade ans = new StockTrade();

        int[] prices = {7, 6, 4, 3, 1};

        int i = ans.maxProfit(prices);

        System.out.println(i);
    }

}
