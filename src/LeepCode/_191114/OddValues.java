package LeepCode._191114;

/**
 * @Author DreamYee
 * @Create 2019/11/14  20:44
 */
/*给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
*/
public class OddValues {
    public int oddCells(int n, int m, int[][] indices) {
        int res=0;
        int[][] matrix=new int[n][m];
        for(int[] index:indices){
            accumulate(matrix,index);
        }
        for(int[] ints:matrix){
            for(int anInt:ints){
                if(anInt%2!=0){
                    res++;
                }
            }
        }
        return res;
    }

    public void accumulate(int[][] matrix,int[] indices){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(i==indices[0]){
                    matrix[i][j]++;
                }
                if(j==indices[1]){
                    matrix[i][j]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        OddValues ov=new OddValues();
        int n=2;
        int m=3;
        int[][] incides={{0,1},{1,1}};
        System.out.println(ov.oddCells(n,m,incides));

    }
}
