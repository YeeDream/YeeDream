package LeepCode._191115;

/**
 * @Author DreamYee
 * @Create 2019/11/15  11:48
 */
/*每个非负整数 N 都有其二进制表示。
例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。
注意，除 N = 0 外，任何二进制表示中都不含前导零。
二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
给定十进制数 N，返回其二进制表示的反码所对应的十进制整数。
*/
public class Replace10Integer {
    public int bitwiseComplement(int N) {
        String s=Integer.toBinaryString(N);//将十进制转化为二进制
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                sb.append(0);
            }
            if(s.charAt(i)=='0'){
                sb.append(1);
            }
        }
        //转化为二进制的数
        return Integer.parseInt(sb.toString(),2);
    }

    public static void main(String[] args) {
        Replace10Integer ri=new Replace10Integer();
        int N=10;
        System.out.println(ri.bitwiseComplement(N));
    }
}
