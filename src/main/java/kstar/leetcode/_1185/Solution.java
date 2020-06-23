package kstar.leetcode._1185;

/**
 * <h6>数学公式法</h6>
 * <p>蔡勒（Zeller）公式：
 * <br/>1582年10月4日之后， w = (y+[y/4]+[c/4]-2c+[26*(m+1)/10]+d-1) mod 7;
 * <br/>1582年10月4日及之前，w = (y+[y/4]+[c/4]-2c+[26*(m+1)/10]+d+2) mod 7;
 * <br/>当年的1,2月要当成上一年的13,14月进行计算</p>
 */
public class Solution {

    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        if (month == 1 || month == 2) {
            --year;
            month += 12;
        }
        int m = month;
        int c = year / 100;
        int y = year % 100;
        int index = (y + y / 4 + c / 4 - 2 * c + 26 * (m + 1) / 10 + day - 1) % 7;
        index = index < 0 ? index + 7 : index;
        return week[index];
    }
}
