package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class IntegerToRoman {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String intToRoman(int num) {
            int[] money = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
            String []str ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

            StringBuilder ans = new StringBuilder();
            int i = 0 ;

            while(num != 0 ){
                if(num >= money[i]){
                    num -= money[i];
                    ans.append(str[i]);
                }else{
                    i++;
                }
            }

            return ans.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new IntegerToRoman().new Solution();
        // put your test code here

    }
}