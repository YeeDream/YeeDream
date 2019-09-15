package 程序设计方法与优化.Abstract;

public class MacFactory implements EFactory {
    public MacRAM produceRAM(){
        return new MacRAM();
    }
    public MacCPU produceCPU(){
        return new MacCPU();
    }
}
