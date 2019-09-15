package 程序设计方法与优化.Abstract;

public class Client {
    public static void main(String[] args) {
        try{
        //    EFactory factory=new MacFactory();
            EFactory factory=new PcFactory();
            RAM ram=factory.produceRAM();
            CPU cpu=factory.produceCPU();
            ram.show();
            cpu.change();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
