package 程序设计方法与优化.工厂方法模式;

public class Test {
    public static void main(String[] args) {
        RobotFactory robotfactory;
        Factory factory;

      //  factory=new HaierAirCondition();
        factory=new MideaAirCondition();
        robotfactory=factory.produceAirCondition();
        robotfactory.produce();

        System.out.println(" ");

    }
}
