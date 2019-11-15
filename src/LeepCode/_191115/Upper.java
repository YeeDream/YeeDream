package LeepCode._191115;

/**
 * @Author DreamYee
 * @Create 2019/11/15  12:22
 */
/*给定一个单词，你需要判断单词的大写使用是否正确。
我们定义，在以下情况时，单词的大写用法是正确的：
全部字母都是大写，比如"USA"。
单词中所有字母都不是大写，比如"leetcode"。
如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
否则，我们定义这个单词没有正确使用大写字母。
*/
public class Upper {
    public boolean detectCapitalUse(String word) {
        char[] cs=word.toCharArray();
        int upper=0;//大写字母个数
        int lower=0;//小写字母个数
        for(int i=0;i<cs.length;i++){
            if(cs[i]>='a'){
                lower++;
            }else {
                upper++;
            }
        }
        if(upper==cs.length){
            return true;
        }
        if(lower==cs.length){
            return true;
        }
        if(cs[0]<'a'&&upper==1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Upper up=new Upper();
        String word="scDe";
        System.out.println(up.detectCapitalUse(word));
    }
}
