package 程序设计方法与优化.工厂方法模式;

public class HaierAirCondition implements Factory {
   public RobotFactory produceAirCondition(){
       System.out.print("海尔工厂生产了");
       return new Haier();
    }
}
