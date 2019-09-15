package 程序设计方法与优化.肯德基点餐系统;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//顾客类
public class Customer  {
    //抽象工厂
    private  Factory factory;

    //构造方法将抽象工厂作为参数传入
    public Customer(Factory factory){
        this.factory=factory;
    }

    //点餐
    private String s[]=new String[16];
    public void showbill() throws IOException{
        BufferedWriter bw=new BufferedWriter(new FileWriter("E:\\大二下\\程序设计优化\\肯德基点餐系统\\Information.txt",true));
        for(int i=0;i<16;i++){
            bw.write(s[i]);
        }
}
    public float orderZingerBurger(int num){
        //获得香辣鸡腿堡
        Hamburger zingerBurger=factory.createZingerBurger(num);
        //输出订购信息
        System.out.println(zingerBurger.printMessage());
        s[0]=zingerBurger.printMessage();
        System.out.print("\n");
        //返回总价
         return zingerBurger.totalPrice();
    }

    public float orderBeefBurger(int num){
        //获得超级牛肉堡
        Hamburger beefBurger=factory.createBeefBurger(num);
        //输出订购信息
        System.out.println(beefBurger.printMessage());
        s[1]=beefBurger.printMessage();
        System.out.print("\n");
        //返回总价
        return beefBurger.totalPrice();
    }

    public float orderOrleansBurger(int num){
        //获得奥尔良烤鸡腿堡
        Hamburger orleansBurger=factory.createOrleansBurger(num);
        //输出订购信息
        System.out.print(orleansBurger.printMessage());
        s[2]=orleansBurger.printMessage();
        //返回总价
        return orleansBurger.totalPrice();
    }

    public float orderShrimpBurger(int num){
        //获得全虾堡
        Hamburger shrimpBurger=factory.createShrimpBurger(num);
        //输出订购信息
        System.out.print(shrimpBurger.printMessage());
        s[3]=shrimpBurger.printMessage();
        System.out.print("\n");
        //返回总价
        return shrimpBurger.totalPrice();
    }

    public float orderChickenWings(int num){
        //获得奥尔良鸡翅
        Chicken chickenWings=factory.createChickenWings(num);
        //输出订购信息
        System.out.print(chickenWings.printMessage());
        s[4]=chickenWings.printMessage();
        System.out.print("\n");
        //返回总价
        return chickenWings.totalPrice();
    }

    public float orderDrumStick(int num){
        //获得烤鸡腿
        Chicken drumStick=factory.createDrumStick(num);
        //输出订购信息
        System.out.print(drumStick.printMessage());
        s[5]=drumStick.printMessage();
        System.out.print("\n");
        //返回总价
        return drumStick.totalPrice();
    }

    public float orderPopcornChicken(int num){
        //获得鸡米花
        Chicken popcornChicken=factory.createPopcornChicken(num);
        //输出订购信息
        System.out.print(popcornChicken.printMessage());
        s[6]=popcornChicken.printMessage();
        System.out.print("\n");
        //返回总价
        return popcornChicken.totalPrice();
    }

    public float orderChips(int num){
        //获得薯条
        Dessert chips=factory.createChips(num);
        //输出订购信息
        System.out.print(chips.printMessage());
        s[7]=chips.printMessage();
        System.out.print("\n");
        //返回总价
        return chips.totalPrice();
    }

    public float orderEggTart(int num){
        //获得蛋挞
        Dessert eggTart=factory.createEggTart(num);
        //输出订购信息
        System.out.print(eggTart.printMessage());
        s[8]=eggTart.printMessage();
        System.out.print("\n");
        //返回总价
        return eggTart.totalPrice();
    }

    public float orderSundae(int num){
        //获得圣代
        Dessert sundae=factory.createSundae(num);
        //输出订购信息
        System.out.print(sundae.printMessage());
        s[9]=sundae.printMessage();
        System.out.print("\n");
        //返回总价
        return sundae.totalPrice();
    }

    public float orderMilky(int num){
        //获得奶茶
        Drinks milky=factory.createMilky(num);
        //输出订购信息
        System.out.print(milky.printMessage());
        s[10]=milky.printMessage();
        System.out.print("\n");
        //返回总价
        return milky.totalPrice();
    }

    public float orderKola(int num){
        //获得可乐
        Drinks kola=factory.createKola(num);
        //输出订购信息
        System.out.print(kola.printMessage());
        s[11]=kola.printMessage();
        System.out.print("\n");
        //返回总价
        return kola.totalPrice();
    }

    public float orderCoffee(int num){
        //获得咖啡
        Drinks coffee=factory.createCoffee(num);
        //输出订购信息
        System.out.print(coffee.printMessage());
        s[12]=coffee.printMessage();
        System.out.print("\n");
        //返回总价
        return coffee.totalPrice();
    }

    public float orderOneCombo(int num){
        //获得单人套餐
        Combo oneCombo=factory.createOneCombo(num);
        //输出订购信息
        System.out.print(oneCombo.printMessage());
        s[13]=oneCombo.printMessage();
        System.out.print("\n");
        //返回总价
        return oneCombo.totalPrice();
    }

    public float orderTwoCombo(int num){
        //获得双人套餐
        Combo twoCmobo=factory.createTwoCombo(num);
        //输出订购信息
        System.out.print(twoCmobo.printMessage());
        s[14]=twoCmobo.printMessage();
        System.out.print("\n");
        //返回总价
        return twoCmobo.totalPrice();
    }

    public float orderThreeCombo(int num){
        //获得三人套餐
        Combo threeCombo=factory.createThreeCombo(num);
        //输出订购信息
        System.out.print(threeCombo.printMessage());
        s[15]=threeCombo.printMessage();
        System.out.print("\n");
        //返回总价
        return threeCombo.totalPrice();
    }
}
