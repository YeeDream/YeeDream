package LeepCode._191106;

/**
 * @Author DreamYee
 * @Create 2019/11/06  22:00
 */
/*在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，
其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
*/

/*判断斜率是否相等即可*/
public class StraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        while(coordinates==null&&coordinates.length<3) {
            return true;
        }
            int x=coordinates[1][0]-coordinates[0][0];
            int y=coordinates[1][1]-coordinates[0][1];
            int dx,dy;
            for(int i=2;i<coordinates.length;i++){
                dx=coordinates[i][0]-coordinates[0][0];
                dy=coordinates[i][1]-coordinates[0][1];
                if(x*dy!=y*dx){
                    return false;
                }
            }
         return true;
    }

    public static void main(String[] args) {
        StraightLine sl=new StraightLine();
        int[][] cc={{1,2},{3,3},{3,4}};
        System.out.println(sl.checkStraightLine(cc));
    }
}
