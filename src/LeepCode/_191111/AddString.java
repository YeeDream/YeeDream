package LeepCode._191111;

/**
 * @Author DreamYee
 * @Create 2019/11/11  14:51
 */
/*给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

注意：
num1 和num2 的长度都小于 5100.
num1 和num2 都只包含数字 0-9.
num1 和num2 都不包含任何前导零。
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
*/
public class AddString {
    public String addStrings(String num1, String num2) {
        StringBuilder stb=new StringBuilder();
        int i=num1.length()-1;
        int j=num2.length()-1;
        int c=0;
        while (i>=0||j>=0||c!=0) {
            if (i >= 0) c += num1.charAt(i--) - '0';
            if (j >= 0) c += num2.charAt(j--) - '0';
            stb.append(c % 10);
            c /=10;
        }
        return stb.reverse().toString();
    }

    public static void main(String[] args) {
        AddString as=new AddString();
        String num1="123";
        String num2="2435";
        System.out.println(as.addStrings(num1,num2));
    }
}
