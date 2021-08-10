package com.algorithm;

/**
 * @Author: zhengyanglee
 * @Date: 2021/8/10 9:25 上午
 */
public class Solution413 {
    /**
     * 给定数组中找到至少3个连续元素为等差数列的子序列个数
     * 1、暴力
     * 2、(n-2)*(n-1)/2 (等差数列求和公式 n*(n-1)/2)
     * @param nums
     * @return
     */
    public static int numberOfArithmeticSlices(int[] nums) {
        return numberOfArithmeticSlicesViolence(nums);

    }
    //如果y+1的位置和x-y不形成等差数列   就没必要再从x+1到y再去判断
    //下次直接从 y的位置开始算
    public static int numberOfArithmeticSlicesGreedy(int[] nums){
        int i=0;
        int j=i+2;
        int result=0;
        while(i<=nums.length-3){
            if(j>=nums.length-1){
                if(j-i>=2&&isArithmeticSlices(nums,i,j)){
                    int n=j-i+1;
                    result=result+(n-2)*(n-1)/2;
                }
                break;
            }
            if(isArithmeticSlices(nums,i,j)){
                j=j+1;
            }else {
                if(j-i>2){
                    int n=j-i;
                    result=result+(n-2)*(n-1)/2;
                }
                i=j-1;
                j=i+1;
            }

        }
        return  result;
    }




    //暴力
    public static int  numberOfArithmeticSlicesViolence(int[] nums){
        if(nums.length<3){
            return 0;
        }
        int result=0;
        for(int i=0;i<=nums.length-3;i++){
            for(int j=i+2;j<nums.length;j++){
                if(isArithmeticSlices(nums,i,j)){
                    result++;
                }else {
                    continue;
                }
            }
        }
        return result;
    }

    public static boolean isArithmeticSlices(int[] nums,int start,int end){
        int gap=nums[start+1]-nums[start];
        for(int i=start;i<end;i++){
            if(nums[i+1]-nums[i]!=gap){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,8,9,10};
        System.out.println(numberOfArithmeticSlicesGreedy(nums));
    }
}
