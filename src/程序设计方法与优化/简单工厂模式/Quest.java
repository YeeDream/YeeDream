package 程序设计方法与优化.简单工厂模式;

public class Quest {
    public static void main(String[] args) {
        PersonFactory p=Nvwa.getpeople("n");
        p.makepeople();
    }
}
