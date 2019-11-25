package LeepCode._191125;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author DreamYee
 * @Create 2019/11/25  15:28
 */
/*给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
注意：每次拼写时，chars 中的每个字母都只能用一次。
返回词汇表 words 中你掌握的所有单词的 长度之和。
*/
public class SpellWords {
    public int countCharacters(String[] words, String chars) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for(int i=0; i<chars.length(); i++) set.add(chars.charAt(i));
        for(String str:words){
            int temp=0;
            for(char c:str.toCharArray()){
                for(int i=0; i<set.size();i++){
                    if(set.contains(c)){
                        temp++;
                        break;
                    }
                }
            }
            if(temp == str.length())
                count += str.length();
        }
        return count;
    }

    public static void main(String[] args) {
        SpellWords sw=new SpellWords();
        String[] words={"hello","world","leetcode"};
        String chars="welldonehoneyr";
        System.out.println(sw.countCharacters(words,chars));
    }
}
