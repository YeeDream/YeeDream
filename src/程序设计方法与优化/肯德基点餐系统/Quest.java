package 程序设计方法与优化.肯德基点餐系统;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;
import java.util.Date;
import 程序设计方法与优化.肯德基点餐系统.Customer;
public class Quest {
    public static void main(String[] args) {
        try{
            Factory factory = new KFCFactory();
            Customer customer = new Customer(factory);

            //创建输出流对象
            FileWriter file = new FileWriter("E:\\大二下\\程序设计优化\\肯德基点餐系统\\Information.txt");
            //字符缓冲输出流
            BufferedWriter bw = new BufferedWriter(file);

            float ZingerBurger = 0;
            float OrleansBurger = 0;
            float BeefBurger = 0;
            float ShrimpBurger = 0;
            float ChickenWings = 0;
            float DrumStick = 0;
            float PopcornChicken = 0;
            float Chips = 0;
            float EggTart = 0;
            float Sundae = 0;
            float Kola = 0;
            float Milky = 0;
            float Coffee = 0;
            float OneCombo = 0;
            float TwoCombo = 0;
            float ThreeCombo = 0;
            Scanner input = new Scanner(System.in);
            bw.write("-------------------------------欢迎光临肯德基店----------------------------------");
            bw.newLine();
            bw.write("*******************************菜单******************************************");
            bw.newLine();
            bw.write("========================汉堡类：===================");
            bw.newLine();
            bw.write("----1.香辣鸡腿堡-----------------------------15.0元");
            bw.newLine();
            bw.write( "----2.奥尔良烤鸡腿堡------------------------17.0元");
            bw.newLine();
            bw.write("----3.超级牛肉堡-----------------------------17.0元");
            bw.newLine();
            bw.write( "----4.全虾堡---------------------------------17.0元");
            bw.newLine();
            bw.write("========================鸡肉类：===================");
            bw.newLine();
            bw.write("----5.奥尔良烤翅------------------------------6.0元");
            bw.newLine();
            bw.write("----6.烤鸡腿----------------------------------12.0元");
            bw.newLine();
            bw.write( "----7.鸡米花--------------------------------11.0元");
            bw.newLine();
            bw.write("========================甜点类：===================");
            bw.newLine();
            bw.write("----8.薯条------------------------------------8.0元");
            bw.newLine();
            bw.write("----9.蛋挞------------------------------------4.0元");
            bw.newLine();
            bw.write("----10.圣代-----------------------------------6.0元");
            bw.newLine();
            bw.write("========================饮品类：===================");
            bw.newLine();
            bw.write("----11.可乐-----------------------------------6.0元");
            bw.newLine();
            bw.write("----12.奶茶-----------------------------------6.0元");
            bw.newLine();
            bw.write("----13.咖啡----------------------------------12.0元");
            bw.newLine();
            bw.write("========================套餐类：===================");
            bw.newLine();
            bw.write("----14.单人套餐------------------------------33.0元");
            bw.newLine();
            bw.write(" 1个香辣鸡腿堡+1个烤鸡腿+1包薯条+1杯可乐/奶茶(任点)     ");
            bw.newLine();
            bw.write("----15.双人套餐-------------------------------54.0元");
            bw.newLine();
            bw.write(" 1个香辣鸡腿堡+1个奥尔良烤鸡腿堡/超级牛肉堡/全虾堡(任点)");
            bw.newLine();
            bw.write( " 1对奥尔良鸡翅+2个蛋挞+2杯可乐/奶茶（任点）"            );
            bw.newLine();
            bw.write("----16.三人套餐------------------------------109.0元");
            bw.newLine();
            bw.write(" 3个奥尔良烤鸡腿堡/超级牛肉堡/全虾堡（任点）          ");
            bw.newLine();
            bw.write( " 1对奥尔良鸡翅+1个烤鸡腿+1包鸡米花"                  );
            bw.newLine();
            bw.write( " 1包薯条+2杯圣代+2杯可乐/奶茶（任点）+1杯咖啡"    );
            bw.newLine();
            bw.write("***********************************************************************************");
            bw.newLine();
            System.out.println("请选择序号点餐：");
            int a = input.nextInt();
            System.out.println("请选择数量：");
            int b = input.nextInt();
            switch (a) {
                case 1:
                    //香辣鸡腿堡
                    ZingerBurger = customer.orderZingerBurger(b);
                    break;
                case 2:
                    //奥尔良烤鸡腿堡
                    OrleansBurger = customer.orderOrleansBurger(b);
                    break;
                case 3:
                    //超级牛肉煲
                    BeefBurger = customer.orderBeefBurger(b);
                    break;
                case 4:
                    //全虾堡
                    ShrimpBurger = customer.orderShrimpBurger(b);
                    break;
                case 5:
                    //奥尔良烤鸡翅
                    ChickenWings = customer.orderChickenWings(b);
                    break;
                case 6:
                    //烤鸡腿
                    DrumStick = customer.orderDrumStick(b);
                    break;
                case 7:
                    //鸡米花
                    PopcornChicken = customer.orderPopcornChicken(b);
                    break;
                case 8:
                    //薯条
                    Chips = customer.orderChips(b);
                    break;
                case 9:
                    //蛋挞
                    EggTart = customer.orderEggTart(b);
                    break;
                case 10:
                    //圣代
                    Sundae = customer.orderSundae(b);
                    break;
                case 11:
                    //可乐
                    Kola = customer.orderKola(b);
                    break;
                case 12:
                    //奶茶
                    Milky = customer.orderMilky(b);
                    break;
                case 13:
                    //咖啡
                    Coffee = customer.orderCoffee(b);
                    break;
                case 14:
                    //单人套餐
                    OneCombo = customer.orderOneCombo(b);
                    break;
                case 15:
                    //双人套餐
                    TwoCombo = customer.orderTwoCombo(b);
                    break;
                case 16:
                    //三人套餐
                    ThreeCombo = customer.orderThreeCombo(b);
                    break;
            }
            System.out.println("请选择是否继续点餐？1：是   2：否");
            int c = input.nextInt();
            float money1 = ZingerBurger + OrleansBurger + BeefBurger + ShrimpBurger;
            float money2 = ChickenWings + DrumStick + PopcornChicken;
            float money3 = Chips + EggTart + Sundae;
            float money4 = Kola + Milky + Coffee;
            float money5 = OneCombo + TwoCombo + ThreeCombo;
            float money = money1 + money2 + money3 + money4 + money5;
            System.out.println("您的本次账单为：" + money);
            System.out.println("请问您是否具有优惠券？1：是 2：否");
            int m = input.nextInt();
            double d = 0;
            if (m == 1) {
                System.out.println("请输入优惠券金额:");
                d=input.nextDouble();
            }
            System.out.println("您的支付金额为：");
            double f = input.nextDouble();
            double changes = f - money + d;
            System.out.println("找零：" + changes);
            /* if (c != 1) {
                    break;
                }*/
            bw.write("######################账单如下#########################");
            bw.newLine();
            bw.write("您的餐品为：");
            bw.newLine();
            bw.write("您本次餐品总计："+money+"元");
            bw.newLine();
            bw.write("您此次优惠券金额为："+d+"元");
            bw.newLine();
            bw.write("您的实付金额为："+f+"元");
            bw.newLine();
            bw.write("找零："+changes+"元");
            bw.newLine();
            bw.write("                   欢迎下次光临！                      ");
            bw.flush();
            bw.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

