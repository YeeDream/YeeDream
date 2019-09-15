package 程序设计方法与优化.肯德基点餐系统;
//汉堡类
public abstract class Hamburger extends AbstractFood implements Food{
    public String printMessage(){
        return("--"+this.kind+"  单价："+this.price+
                "  数量："+this.num+"  合计："+this.totalPrice());
    }
}
