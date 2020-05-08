package leetcode;

public class LeetCode1604 {
    /**
     * 面试题39. 数组中出现次数超过一半的数字
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 示例 1:
     * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
     * 输出: 2
     * 限制：
     * 1 <= 数组长度 <= 50000
     */

    public static int majorityElement(int[] nums) {
        if(nums.length==0){
            return 0;
        }

        int temp=0;
        int count = 0;
        for(int i=0,len=nums.length;i<len;i++){
            if(count==0){
                temp=nums[i];
                count++;
            }else{
                if(nums[i]!=temp){
                    count--;
                }else{
                    count++;
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(arr));
    }
}
