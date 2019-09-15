package 程序设计方法与优化.Abstract;

public class PcFactory implements EFactory {
    public PcRAM produceRAM(){
        return new PcRAM();
    }
    public PcCPU produceCPU(){
        return new PcCPU();
    }
}
