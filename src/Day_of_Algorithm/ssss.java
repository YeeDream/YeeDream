package Day_of_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author DreamYee
 * @Create 2019/11/23  10:25
 */
/*输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。*/
public class ssss {
    public static ArrayList<String> Permutation(String str){
        ArrayList<String > resultlist  = new ArrayList<String>();

        if(str.length()==0 || str==null){
            return (ArrayList)resultlist;
        }

        char[]  chars = str.toCharArray();
        findsublist(chars,resultlist,0);

        Collections.sort(resultlist);
        return (ArrayList)resultlist;
    }
    public static  void findsublist(char[] a, List<String> list, int i){
        //递归终止条件
        if(i==a.length-1){
            if(!list.contains(new String(a)))
                list.add(new String(a));
            return ;

        }else{
            //递归
            for (int j = i; j <a.length;j++){
                swap(a,i,j);
                findsublist(a,list,i+1);
                swap(a,i,j);
            }
        }
    }

    public static void swap(char[] str,int i,int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }


}
