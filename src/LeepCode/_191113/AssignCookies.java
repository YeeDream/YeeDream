package LeepCode._191113;

import java.util.Arrays;

/**
 * @Author DreamYee
 * @Create 2019/11/13  16:37
 */
/*假设你是一位很棒的家长，想要给你的孩子们一些小饼干。
但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；
并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
*/
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int child=0;
        int cookie=0;
        Arrays.sort(s);
        Arrays.sort(g);
        while (child<g.length&&cookie<s.length){
            if(g[child]<=s[cookie]){
                child++;
            }
            cookie++;
        }
        return child;
    }

    public static void main(String[] args) {
        AssignCookies ac=new AssignCookies();
        int[] g={10,9,8,7};
        int[] s={5,6,7,8};
        System.out.println(ac.findContentChildren(g,s));
    }
}
