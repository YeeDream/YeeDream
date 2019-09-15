package 程序设计方法与优化.工厂方法模式;

public class Midea implements RobotFactory {
    @Override
    public void produce() {
        System.out.println("美的空调");
    }
}
