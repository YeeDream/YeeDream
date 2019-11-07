package LeepCode._191107;

/**
 * @Author DreamYee
 * @Create 2019/11/07  19:35
 */

/*数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
最开始的时候，同一位置上也可能放着两个或者更多的筹码。
返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
*/

/*解法：比较奇偶数最少的数目*/
public class 玩筹码 {
    public int minCostToMoveChips(int[] chips) {
        int even=0,odd=0;
        for(int i=0;i<chips.length;i++){
            if(chips[i]%2==0){
                even++;
            }else if(chips[i]%2!=0){
                odd++;
            }
        }
        return Math.min(even,odd);
    }

    public static void main(String[] args) {
        int[] chips={2,2,2,3,3};
        玩筹码 w=new 玩筹码();
        System.out.println(w.minCostToMoveChips(chips));
    }
}
