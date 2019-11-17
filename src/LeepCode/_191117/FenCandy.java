package LeepCode._191117;

import java.util.HashSet;

/**
 * @Author DreamYee
 * @Create 2019/11/17  8:40
 */
/*给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
*/
public class FenCandy {
    //通过哈希表计算最大种类set.size(),一个人最多能分到一半糖果candies.length/2;
    //两者之间的最小值为可以分到的最大种类数
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set=new HashSet<>();
        for(int candy:candies){
            set.add(candy);
        }
        return Math.min(set.size(),candies.length/2);
    }

    public static void main(String[] args) {
        FenCandy fc=new FenCandy();
        int[] candies={1,1,2,2,3,3};
        System.out.println(fc.distributeCandies(candies));
    }
}
