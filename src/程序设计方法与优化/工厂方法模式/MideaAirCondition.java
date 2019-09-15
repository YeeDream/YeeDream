package 程序设计方法与优化.工厂方法模式;

public class MideaAirCondition implements Factory {
    public RobotFactory produceAirCondition(){
        System.out.print("美的工厂生产了");
        return new Midea();
    }
}
