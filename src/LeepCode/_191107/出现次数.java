package LeepCode._191107;

/**
 * @Author DreamYee
 * @Create 2019/11/07  19:52
 */

/*给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
*/

public class 出现次数 {
    public boolean uniqueOccurrences(int[] arr) {
        boolean flag=true;
        int[] num=new int[2000];
        for(int i=0;i<arr.length;i++){
            num[arr[i]] += 1;
        }
        for(int i=0;i<num.length;i++){
            for(int j=i+1;j<num.length;j++){
                if(num[i]==num[j] && num[i]>0 && num[j]>0){
                    flag=false;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] arr={-3,0,1,-3,1,1,1,-3,10,0};
        出现次数 cc=new 出现次数();
        System.out.println(cc.uniqueOccurrences(arr));
    }
}
