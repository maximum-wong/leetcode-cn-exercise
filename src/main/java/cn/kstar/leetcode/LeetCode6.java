package cn.kstar.leetcode;

/**
 * <h3>Zig Zag</h3>
 * <h3>Z字型变换</h3>
 * 
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。比如输入字符串为 "LEETCODEISHIRING"行数为3时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如： "LCIRETOESIIGEDHN"
 * 
 * 请你实现这个将字符串进行指定行数变换的函数：string convert(string s, int numRows);
 * Example 1:
 * Input: s = "LEETCODEISHIRING", numRows = 3
 * Output: "LCIRETOESIIGEDHN"
 * Example 2:
 * Input: s = "LEETCODEISHIRING", numRows = 4
 * Output: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class LeetCode6 {

    public String convert(String input, int numRows) {
        // 获取字符数组
        char[] array = input.toCharArray();
        int length = input.length();
        // 构建二维数组
        CharSequence[] charSequences = new CharSequence[numRows];
        for (int i = 0; i < numRows; i++) {
            charSequences[i] = new CharSequence(length);
        }
        int index = 0;
        // 遍历原始数组，构建Z字形二维数组
        while (index < length) {
            // 垂直方向添加元素
            for (int i = 0; (i < numRows) && (index < length); i++) {
                charSequences[i].append(array[index++]);
            }
            // 斜右向添加元素
            for (int i = numRows - 2; (i > 0) && (index < length); i--) {
                charSequences[i].append(array[index++]);
            }
        }
        // 拼接字符
        for (int i = 1; i < numRows; i++) {
            charSequences[0].append(charSequences[i]);
        }
        return charSequences[0].toString();
    }

    public class CharSequence {

        public CharSequence(int capacity) {
            this.arry = new char[capacity];
            this.capacity = capacity;
        }

        private char[] arry;
        private int capacity;
        private int position = 0;
        private int size = 0;

        public char[] getArry() {
            return arry;
        }

        public int getCapacity() {
            return capacity;
        }

        public int getPosition() {
            return position;
        }

        public int getSize() {
            return size;
        }

        public void append(char ch) {
            if (size == capacity) {
                capacity = (capacity << 1) + 2;
                char[] newArray = new char[capacity];
                System.arraycopy(arry, 0, newArray, 0, size);
                arry = newArray;
            }
            this.arry[position++] = ch;
            size++;
        }

        public void append(CharSequence sequence) {
            int totalSize = size + sequence.getSize();
            if (totalSize <= capacity) {
                System.arraycopy(sequence.getArry(), 0, arry, size, sequence.getSize());
            } else {
                int times = totalSize / capacity;
                capacity = capacity << times + (times << 1);
                char[] newArray = new char[capacity];
                System.arraycopy(arry, 0, newArray, 0, size);
                System.arraycopy(sequence.getArry(), 0, newArray, size, sequence.getSize());
                arry = newArray;
            }
            position = size + sequence.getPosition();
            size = size + sequence.getSize();
        }

        @Override
        public String toString() {
            return new String(arry, 0, size);
        }
    }
    
    public static void main(String[] args) {
        LeetCode6 leetCode6 = new LeetCode6();
//        String result = leetCode6.convert("LEETCODEISHIRING", 3);
//        System.out.println(result); // LCIRETOESIIGEDHN
//        String result = leetCode6.convert("LEETCODEISHIRING", 4);
//        System.out.println(result); // LDREOEIIECIHNTSG
//        String result = leetCode6.convert("LEETCODEISHIRING", 5);
//        System.out.println(result); // LIEESGEDHNTOIICR
        String result = leetCode6.convert("LEETCODEISHIRING", 6);
        System.out.println(result); // LHESIEIRTEICDNOG
    }
}
