package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class Sqrtx {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isTrue(long x, long target) {
            return (x * x) < target;
        }

        public int mySqrt(int x) {
            int l = 0;
            int r = x;
            while(l + 1 != r && l != r){
                int mid = (l + r) / 2;
                if(isTrue(mid , x)){
                    l = mid;
                } else {
                    r = mid;
                }
            }

            if(r * r == x){
                return r;
            }
            if(l * l == x){
                return l;
            }

            if((r + l) / 2.0 < x){
                return l;
            }
            else{
                return r;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        // put your test code here
        int x = 2147483647;
        solution.mySqrt(x);
    }
}