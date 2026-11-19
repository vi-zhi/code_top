package leetcode.editor.cn.doc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author vizhi
 * 描述 :
 * @create 2026-04-25 22:07
 */
public class oj2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = scanner.nextInt();
        }

        int ans = getBalance(count, nums);
        System.out.println(ans);
    }

    public static int getCountTwo(int l, int r) {
        int count = 0;
        int index = 0;
        int[] nums = new int[r - l - 1];
        for (int i = l; i <= r; i++) {
            nums[index++] = i;
        }
        String string = Arrays.toString(nums);
        for(int i = 0 ;i < string.length();i++){
//            if(strin)
        }
        return 0;
    }


    public static int getBalance(int count, int[] nums) {
        if (count % 2 == 0) {
            return -1;
        }
        int l = 0;
        int r = 0;
        int lp = 0;
        int rp = count - 1;

        while (lp < rp) {
            if (l < r) {
                l += nums[lp++];
            } else if (l > r) {
                r += nums[rp--];
            } else {
                l += nums[lp++];
                r += nums[rp--];
            }
        }

        if (l != r) {
            return -1;
        }

        return lp;
    }
}
