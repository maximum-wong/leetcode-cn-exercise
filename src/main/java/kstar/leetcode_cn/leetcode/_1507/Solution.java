package kstar.leetcode_cn.leetcode._1507;

public class Solution {

    public String reformatDate(String date) {
        String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

        String[] parts = date.split(" ");

        String day = null;
        for (int i = 0; i < parts[0].length(); i++) {
            char ch = parts[0].charAt(i);
            if (ch < 48 || ch > 57) {
                day = parts[0].substring(0, i);
                break;
            }
        }
        day = (day.length() == 1) ? ("0" + day) : day;

        String month = null;
        for (int i = 0; i < months.length; i++) {
            if (parts[1].equals(months[i])) {
                i = i + 1;
                month = (i < 10) ? ("0" + i) : (i + "");
                break;
            }
        }

        return parts[2] + "-" + month + "-" + day;
    }
}
