package Algorithm.DaV_分治算法;

/**
 * @Author DreamYee
 * @Create 2019/10/19  8:50
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoitower(5,'a','b','c');
    }

    //汉诺塔的移动的方法
    //使用分治算法
    public static void hanoitower(int num,char a,char b,char c){
        //如果只有1个盘
        if(num==1){
            System.out.println("第1个盘从 "+a+"->"+c);
        }else{
            //如果有n>=2个盘
            //1.先把最上面的所有盘a->b,移动过程会使用c
            hanoitower(num-1,a,c,b);
            //2.把最下面的盘a->c
            System.out.println("第"+num+"个盘从 "+a+"->"+c);
            //3.把b塔所有的盘b->c,移动过程会使用a
            hanoitower(num-1,b,a,c);

        }
    }
}
