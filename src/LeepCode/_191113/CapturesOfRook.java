package LeepCode._191113;

/**
 * @Author DreamYee
 * @Create 2019/11/13  16:53
 */
/*在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。
它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），
然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。
另外，车不能与其他友方（白色）象进入同一个方格。
返回车能够在一次移动中捕获到的卒的数量。
*/
public class CapturesOfRook {
    public int numRookCaptures(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                //找到R的位置
                if(board[i][j]=='R'){
                    //依次上下右左找
                    return cap(board,i,j,0,1)+cap(board,i,j,0,-1)+cap(board,i,j,1,0)+cap(board,i,j,-1,0);
                }
            }
        }
        return 0;
    }

    /**
     *
     * @param a 原数组矩阵
     * @param x
     * @param y（x,y）为R的坐标
     * @param dx
     * @param dy （dx,dy）增长步长
     * @return
     */
    public int cap(char[][] a,int x,int y,int dx,int dy){
        while (x>=0&&x<a.length&&y>=0&&y<a[x].length&& a[x][y]!='B'){
            if(a[x][y]=='p') {
                return 1;
            }
            x+=dx;
            y+=dy;
        }
        return 0;
    }
    public static void main(String[] args) {
        CapturesOfRook cr=new CapturesOfRook();
        char[][] board={{'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}};
        System.out.println(cr.numRookCaptures(board));
    }
}
