package kstar.leetcode_cn.leetcode._0229;

import java.util.ArrayList;
import java.util.List;

/**
 * <h6>摩尔投票法</h6>
 */
public class Solution {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        // 定义两个候选人及其对应的票数
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        int count1 = 0;
        int count2 = 0;

        // 遍历数组，选出两个候选人
        for (int num : nums) {
            // 如果与候选人1相同，投候选人1
            if (num == candidate1) {
                count1++;
                continue;
            }

            // 如果与候选人2相同，投候选人2
            if (num == candidate2) {
                count2++;
                continue;
            }

            // 候选人1的票数为0，候选人1更新为当前num
            if (count1 == 0) {
                candidate1 = num;
                count1++;
                continue;
            }

            // 候选人2的票数为0，候选人2更新为当前num
            if (count2 == 0) {
                candidate2 = num;
                count2++;
                continue;
            }

            // 既不是候选人1也不是候选人2，分别减少他们的票数
            count1--;
            count2--;
        }

        // 分别统计新选出来的候选人的票数
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        // 记录票数超过1/3的候选人
        if (count1 > nums.length / 3) {
            res.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            res.add(candidate2);
        }

        return res;
    }
}
