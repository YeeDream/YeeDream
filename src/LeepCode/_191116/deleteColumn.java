package LeepCode._191116;

/**
 * @Author DreamYee
 * @Create 2019/11/16  14:11
 */
/*给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，
形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。
*/
public class deleteColumn {
    //找出降序的列数
    public int minDeletionSize(String[] A) {
        int count=0;
        for(int i=0;i<A[0].length();i++){
            for(int j=1;j<A.length;j++){
                if(A[j-1].charAt(i)>A[j].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        deleteColumn dc=new deleteColumn();
        String[] a={"cba","daf","ghi"};
        System.out.println(dc.minDeletionSize(a));
    }
}
