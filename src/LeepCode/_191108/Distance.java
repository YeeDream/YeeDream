package LeepCode._191108;

/**
 * @Author DreamYee
 * @Create 2019/11/08  18:22
 */
/*环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。
我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
环线上的公交车都可以按顺时针和逆时针的方向行驶。
返回乘客从出发点 start 到目的地 destination 之间的最短距离。
*/
public class Distance {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int d1=0;
        int d2=0;
        int d3=0;
        if(start>destination){
            int temp=start;
            start=destination;
            destination=temp;
        }
        //直达节点距离
        for(int i=start;i<destination;i++){
            d1=d1+distance[i];
        }
        //初始到start的距离
        for(int j=0;j<start;j++){
            d2=d2+distance[j];
        }
        //destination到最后的距离
        for(int k=destination;k<distance.length;k++){
            d3=d3+distance[k];
        }

        int d4=d2+d3;
        int res=Math.min(d1,d4);
        return res;
    }

    public static void main(String[] args) {
        Distance dd=new Distance();
        int[] arr={1,2,3,4};
        System.out.println(dd.distanceBetweenBusStops(arr,0,2));
    }
}
