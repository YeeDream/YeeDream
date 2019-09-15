package 程序设计方法与优化.肯德基点餐系统;

import sun.security.provider.Sun;

//具体工厂
public class KFCFactory implements Factory {
    //生产香辣鸡腿堡
    public ZingerBurger createZingerBurger(int num){
        return new ZingerBurger(num);
    }

    //生产超级牛肉堡
    public BeefBurger createBeefBurger(int num){
        return new BeefBurger(num);
    }

    //生产奥尔良烤鸡腿堡
    public OrleansBurger createOrleansBurger(int num){
        return new OrleansBurger(num);
    }

    //生产全虾堡
    public ShrimpBurger createShrimpBurger(int num){
        return new ShrimpBurger(num);
    }

    //生产奥尔良鸡翅
    public ChickenWings createChickenWings(int num){
        return new ChickenWings(num);
    }

    //生产烤鸡腿
    public DrumStick createDrumStick(int num){
        return new DrumStick(num);
    }

    //生产鸡米花
    public PopcornChicken createPopcornChicken(int num){
        return new PopcornChicken(num);
    }

    //生产薯条
     public Chips createChips(int num){
        return new Chips(num);
     }

    //生产蛋挞
    public EggTart createEggTart(int num){
        return new EggTart(num);
    }

    //生产圣代
    public Sundae createSundae(int num){
        return new Sundae(num);
    }

    //生产奶茶
    public Milky createMilky(int num){
        return new Milky(num);
    }

    //生产可乐
    public Kola createKola(int num){
        return new Kola(num);
    }

    //生产咖啡
    public Coffee createCoffee(int num){
        return new Coffee(num);
    }

    //生产单人套餐
    public OneCombo createOneCombo(int num){
        return new OneCombo(num);
    }
    //生产双人套餐
    public TwoCombo createTwoCombo(int num){
        return new TwoCombo(num);
    }

    //生产三人套餐
    public ThreeCombo createThreeCombo(int num){
        return new ThreeCombo(num);
    }
}
