package LeepCode._191106;
import java.util.Scanner;
/**
 * @Author DreamYee
 * @Create 2019/11/06  21:50
 */
/*给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
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
