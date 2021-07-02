package com.algorithm;

/**
 * @author zhengyanglee
 */
public class Solution4 {
    /**
     *
     * @param nums1 已排序整数
     * @param nums2 已排序整数
     * @return 返回中位数   时间复杂度 lg(n+m)
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lhs=0,rhs=0;
        int length=nums1.length+nums2.length;
//        0,1,2,3,4
//        mid=2   奇数 length/2
//         0,1,2,3,4,5
//        mid=2 偶数  length-1/2
        boolean isEven=length%2==0;
        int mid=isEven?(length-1)/2:length/2;
        int index=0;
        while(index<mid){
            if(nums1[lhs]<nums2[rhs]){
                if(lhs<nums1.length-1){
                    lhs=++lhs;
                }else {
                    rhs=++rhs;
                }
            }else {
                if(rhs<nums2.length-1){
                    rhs=++rhs;
                }else {
                    lhs=++lhs;
                }
            }
            index=++index;
        }

        /**
         * [x,x,x,x,x,x]
         *            ⬆️
         *            lhs
         * [x,x,x,x,x,x]
         * ⬆️
         * rhs
         */
        int lhsTemp, rhsTemp;
        if(lhs==0){
            lhsTemp=nums2[rhs];
        }
        if(rhs==0){
            lhsTemp=nums1[lhs];
        }
//
//        int lhsTemp, rhsTemp;
//        if (lhs == 0) {
//            lhsTemp = nums2[rhs];
//            if(rhs==nums2.length){
//                rhsTemp=nums1[0];
//            }else {
////                rhsTemp
//            }
//        } else if (rhs == 0) {
//            lhsTemp = nums1[lhs];
//        } else {
//            lhsTemp = nums1[lhs] < nums2[rhs] ? nums2[rhs] : nums1[lhs];
//        }


//        int lhsTemp=nums1[lhs]<nums2[rhs]?nums2[rhs]:nums1[lhs];
//        int x=0,y=0;
//        if(lhs<nums1.length-1){
//            x=++lhs;
//        }
//        if(rhs<nums2.length-1){
//            y=++rhs;
//        }
//        if(x==0){
//            return ((double)(lhsTemp+nums2[y])/(double)2);
//        }
//        if(y==0){
//            return ((double)(lhsTemp+nums1[x])/(double)2);
//        }
//        if(nums1[x]<nums1[y]){
//          return   (double)(lhsTemp+nums1[x])/(double)2;
//        }
//        return  (double)(lhsTemp+nums2[y])/(double)2;
        return 0;
    }

    public static void main(String[] args) {
        int []num1={1,2,3};
        int []num2={4,5,6};
        double result=findMedianSortedArrays(num1,num2);
        System.out.println(result);
    }
}
