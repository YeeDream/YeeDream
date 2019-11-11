package LeepCode._191111;

/**
 * @Author DreamYee
 * @Create 2019/11/11  14:34
 */
/*给定两个二进制字符串，返回他们的和（用二进制表示）。
输入为非空字符串且只包含数字 1 和 0。*/
public class binaryAdd {
    public String addBinary(String a, String b) {
        if(a==null||a.length()==0) return b;
        if(b==null||b.length()==0) return a;

        StringBuilder stb=new StringBuilder();
        int i=a.length()-1;
        int j=b.length()-1;

        int c=0;//进位
        while (i>=0||j>=0) {
            if (i >= 0) c += a.charAt(i--) - '0';
            if (j >= 0) c += b.charAt(j--) - '0';
            stb.append(c % 2);
            c >>= 1;
        }
        String res=stb.reverse().toString();
        return c>0 ? '1'+res : res;
    }

    public static void main(String[] args) {
        binaryAdd bb=new binaryAdd();
        String a="1010";
        String b="1011";
        System.out.println(bb.addBinary(a,b));

    }
}
