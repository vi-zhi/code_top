package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class BestTimeToBuyAndSellStock {

    static class Solution {
        public int maxProfit(int[] prices) {

            int Profit = 0;
            int min = 0;
            for(int i = 0 ; i < prices.length ;i++){
                if(prices[min] > prices[i]){
                    min = i;
                }else if(prices[i] - prices[min] > Profit){
                    Profit = prices[i] - prices[min];
                }
            }
            return Profit;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        // put your test code here



    }
}