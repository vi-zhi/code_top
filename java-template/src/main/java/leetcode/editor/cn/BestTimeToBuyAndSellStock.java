package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class BestTimeToBuyAndSellStock {

    //leetcode submit region begin(Prohibit modification and deletion)
     class Solution {
        public int maxProfit(int[] prices) {
            int min = 0;
            int maxProfit = 0;
            for(int i = 0 ; i< prices.length ;i++){
                if(prices[i] <  prices[min]){
                    min = i;
                }
                if(prices[i] - prices[min] > maxProfit ){
                    maxProfit = prices[i] - prices[min];
                }
            }
            return maxProfit;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        // put your test code here
        
    }
}