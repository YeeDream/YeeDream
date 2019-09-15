package 程序设计方法与优化.肯德基点餐系统;
//肯德基抽象工厂
public interface Factory {
    public interface  factory{
        //生产汉堡
        public Hamburger createHamburger(int num);

        //生产鸡肉类食物
        public Chicken createChicken(int num);

        //生产甜点
        public Dessert createDessert(int num);

        //生产饮品
        public Drinks createDrinks(int num);
    }
    public Hamburger createZingerBurger(int num);
    public Hamburger createBeefBurger(int num);
    public Hamburger createOrleansBurger(int num);
    public Hamburger createShrimpBurger(int num);
    public Chicken createDrumStick(int num);
    public Chicken createChickenWings(int num);
    public Chicken createPopcornChicken(int num);
    public Dessert createChips(int num);
    public Dessert createEggTart(int num);
    public Dessert createSundae(int num);
    public Drinks createMilky(int num);
    public Drinks createKola(int num);
    public Drinks createCoffee(int num);
    public Combo createOneCombo(int num);
    public Combo createTwoCombo(int num);
    public Combo createThreeCombo(int num);

}
