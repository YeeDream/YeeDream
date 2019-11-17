package LeepCode._191117;

/**
 * @Author DreamYee
 * @Create 2019/11/17  8:28
 */
public class fib {
    public int fib(int N) {
        if(N==0){
            return 0;
        }
        if(N==1){
            return 1;
        }
        return fib(N-1)+fib(N-2);
    }

    public static void main(String[] args) {
        fib ff=new fib();
        int N=2;
        System.out.println(ff.fib(N));
    }
}
