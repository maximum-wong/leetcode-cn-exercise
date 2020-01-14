package cn.kstar.leetcode;

/**
 * <h3>Median of Two Sorted Arrays</h3>
 * <h3>寻找两个有序数组的中位数</h3>
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n))..
 * 给出两个有序的数字列表，长度分别为m,n。找到这两个列表中的中间值，时间复杂度为O(log (m+n))。
 * 
 * 例如:
 * 
 * #例子一：总长度为奇数
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * 
 * #例子二：总长度为偶数
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class LeetCode4 {

    /**
     * 在任一位置 i 将 A 划分成两个部分：
     *                 left_A   |  right_A      
     * A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
     * 类似,
     *                left_B    |  right_B      
     * B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
     * 把A,B两个数组合并一下:
     *       left_part          |        right_part
     * A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
     * B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
     * 
     * 按照中位数的定义，问题求解变成:
     * 1.len(leftPart) = len(rightPart)
     * 2.max(leftPart) ≤  min(rightPart)
     * 3.median = [max(leftPart) + min(rightPart)] / 2
     * 
     * 这个还是不那么好求解,我们还是不知道怎么去在规定时间复杂度时间内搜索出max(leftPart) 和 min(rightPart)
     * ,这需要一下找一下i和j之间的关系。为了简化分析，我们先不考虑 i=0，i=m，j=0,j=n 这样的临界条件。
     * 
     * 1.len(leftPart) = len(rightPart)条件转化为:
     * i+j = m−i+n−j+1
     * i+j = (m+n+1)/2
     * j = (m+n+1)/2 - i
     * j > 0, (m+n+1)/2 > i
     * i∈[0,m], (m+n+1)/2 > m
     * n+1 > m
     * ∴ 当n ≥ m才能使用上面的关系.
     * 
     * 2.max(leftPart) ≤ min(rightPart)条件转化为：B[j−1] ≤ A[i] 且 A[i-1] ≤ B[j]
     * 
     * 3.条件三分一下奇数和偶数:
     * a. 当 m + n为奇数时,中位数为：max(A[i−1], B[j−1])
     * b. 当 m + n为偶数时,中位数为：max(A[i−1], B[j−1]) + min(A[i], B[j]) / 2
     * 
     * 下面开始二分查找:
     * 1.设 imin = 0，imax = m, 然后开始在 [imin,imax] 中进行搜索。
     * 2. i = (imin + imax) / 2, j = (m+n+1) / 2 -i
     * 3.开始搜索上面的第二个条件:
     *       a. B[j−1]≤A[i] 且 A[i−1]≤B[j]：
     *           找到目标对象,分奇数和偶数求解.
             b. B[j−1]>A[i]:
                               这意味着A[i] 太小，我们必须调整 i 以使B[j−1]≤A[i]
                               怎么调整? 增大i,在[i+1,imax]区域二分
                 (1)增大i,j变小. B[j−1]会减小,A[i]会增大,可以向解空间靠近一步.
                 (2)减小i,j变大. B[j−1]会变大,A[i]会减小,不能这么搜索.
             c. A[i−1]>B[j]:
                              类似b,减小i,在[imin,i−1]区域二分  
     * 
     * 主算法完成了,来考虑边界问题吧。
     * i=0,i=m,j=0,j=n，此时A[i−1],B[j−1],A[i],B[j] 可能不存在。
     * 我们需要做的是确保max(leftPart)≤min(rightPart)。 
     * 如果A[i−1],B[j−1],A[i],B[j] 中部分不存在，那么我们只需要检查这两个条件中的一个（或不需要检查）
     * 
     * @param a
     * @param b
     * @return
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // 交换m, n，保证n ≥ m
            int[] temp = A;
            A = B;
            B = temp;
            int tep = m;
            m = n;
            n = tep;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = iMin + 1; // i 太小
            } else if (i > iMin && A[i -1] > B[j]) {
                iMax = iMax - 1; // i 太大
            } else { // 命中目标，分为基数和偶数情况
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i -1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                
                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }
                
                return (maxLeft+minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
