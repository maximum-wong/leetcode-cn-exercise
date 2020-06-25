package kstar.leetcode_cn.leetcode._0006;

/**
 * <h6>Z字型变换
 * <br/>Zig Zag</h6>
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
 * 
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class LeetCode6 {

    /**
     * <h6>逐行拼接法</h6>
     * 
     * <p>时间复杂度：O(n)；空间复杂度：O(2*numRows*n)</p>
     * 
     * @param  input
     * @param  numRows
     * @return String
     */
    public String convert(String input, int numRows) {
        // 空字符、numRows为1、numRows长度大于字符串长度的直接返回输入的字符
        if ((input == null) || (input.length() == 0) || (numRows == 1) || (numRows > input.length()))
            return input;

        int length = input.length();
        // 构建二维数组
        CharSequence[] charSequences = new CharSequence[numRows];
        for (int i = 0; i < numRows; i++) {
            charSequences[i] = new CharSequence(length);
        }

        // 遍历原始数组，构建Z字形二维数组
        int index = 0;
        while (index < length) {
            // 垂直方向添加元素
            for (int i = 0; (i < numRows) && (index < length); i++) {
                charSequences[i].append(input.charAt(index++));
            }
            // 斜右向添加元素
            for (int i = numRows - 2; (i > 0) && (index < length); i--) {
                charSequences[i].append(input.charAt(index++));
            }
        }
        // 拼接字符
        for (int i = 1; i < numRows; i++) {
            charSequences[0].append(charSequences[i]);
        }
        return charSequences[0].toString();
    }

    /**
     * <h6>公式法</h6>
     * 
     * <p>时间复杂度：O(n)；空间复杂度：O(n)</p>
     * 
     * <pre>
     * 0    6
     * 1  5 7
     * 2 4  8
     * 3    9
     * </pre>
     * <p>第 i 行，第 n 列中垂直方向字符索引的位置：n * (2 * numRows - 2) + i, (i>0 && i<numRows)
     * <br/>第 i 行，第 n 列中斜方向的字符索引的位置：(n + 1) * (2 * numRows - 2) - i, (i>0 && i<numRows - 1)</p>
     * 
     * @param  input
     * @param  numRows
     * @return String
     */
    public String convert2(String input, int numRows) {
        // 空字符、numRows为1、numRows长度大于字符串长度的直接返回输入的字符
        if ((input == null) || (input.length() == 0) || (numRows == 1) || (numRows > input.length()))
            return input;

        int length = input.length();
        // 每列之间的差值
        int step = 2 * numRows - 2;
        CharSequence cs = new CharSequence(length);

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < length; j += step) { // 处理每行垂直方向的字符
                cs.append(input.charAt(j + i));
                if ((i > 0) && (i < numRows - 1) && (j + step - i < length)) { // 处理斜向方的元素
                    cs.append(input.charAt(j + step - i));
                }
            }
        }

        return cs.toString();
    }

    /**
     * <h6>找规律法；</h6>
     * 
     * <pre>
     * 0    6
     * 1  5 7
     * 2 4  8
     * 3    9
     * </pre>
     * 
     * <p>第一行、最后一行做特殊处理,两个字母间隔恰好为：step = 2 * numRows - 2；
     * <br/>中间的行规律：如果是在Z字的上半部分，index = current + step;
     * <br/>如果是在Z字的下半部分，index = current + step - 2 * row;</p>
     *  
     * @param s
     * @param numRows
     * @return String
     */
    public String convert3(String s, int numRows) {
        // 空字符、numRows为1、numRows长度大于字符串长度的直接返回输入的字符
        if ((s == null) || (s.length() == 0) || (numRows == 1) || (numRows > s.length()))
            return s;

        int length = s.length();
        // 每列之间的差值
        int step = 2 * numRows - 2;
        CharSequence cs = new CharSequence(length);

        // 处理第一行
        for (int i = 0; i < length; i += step) {
            cs.append(s.charAt(i));
        }
        // 处理中间行
        int row = 1;
        while (row < numRows - 1) {
            int current = row;
            while (current < length) {
                // 处理上半部分
                cs.append(s.charAt(current));
                // 处理下半部分
                int cNext = current + step - 2 * row;
                if (cNext < length) {
                    cs.append(s.charAt(cNext));
                }
                current += step;
            }
            row++;
        }

        // 处理最后一行
        while (row < length) {
            cs.append(s.charAt(row));
            row += step;
        }
        return cs.toString();
    }

    /**
     * <h3>自定义字符串缓冲池类</h3>
     */
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
