package LeepCode._191106;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author DreamYee
 * @Create 2019/11/06  21:37
 */

/*给出一个函数  f(x, y) 和一个目标结果 z，请你计算方程 f(x,y) == z 所有可能的正整数 数对 x 和 y。*/
public class function {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res=new LinkedList<>();
        int start=1;
        int end=1000;
        while(start<=1000&&end>=1){
            int r= customfunction.f(start,end);
            if(r==z){
                List<Integer> tmp=new LinkedList<>();
                tmp.add(start);
                tmp.add(end);
                res.add(tmp);
            }else if(r>z){
                end--;
            }else {
                start++;
            }
        }
        return res;
    }


}
