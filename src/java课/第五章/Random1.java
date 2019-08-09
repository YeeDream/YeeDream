package java课.第五章;
import java.util.Random;
public class Random1{
    public static void main(String[] args) {
        Random ra=new Random();

        for(int i=0;i<5;i++){
            int a=(20+ra.nextInt(11));
            System.out.println(a);
        }

    }
}
