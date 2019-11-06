package LeepCode._191106;
import java.util.Scanner;
/**
 * @Author DreamYee
 * @Create 2019/11/06  21:50
 */
public class IP {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }

    public static void main(String[] args) {
        IP ip=new IP();
        Scanner in=new Scanner(System.in);
        String address=in.next();
        ip.defangIPaddr(address);
        System.out.println(ip.defangIPaddr(address));
    }
}
